package adeo.leroymerlin.cdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAllBy();
    }

    public void delete(Long id) {
        eventRepository.delete(id);
    }

    public Event saveEvent(Event event){return eventRepository.save(event);}

    public List<Event> getFilteredEvents(String query) {
        List<Event> events = eventRepository.findAllBy();
        // Create value that will store the result of the filtering
        List<Event> results = new ArrayList<Event>();
        for(Event event: events){
            Set<Band> bands = new HashSet<Band>();
            for(Band band : event.getBands()){
                Set<Member> members = new HashSet<Member>();
                for(Member member: band.getMembers()){
                    if(member.getName().contains(query)){
                        members.add(member);
                    }
                }
                if(members.size() > 0){
                    band.setName(band.getName()+" ["+members.size()+"]");
                    band.setMembers(members);
                    bands.add(band);
                }
            }
            if(bands.size() > 0){
                event.setTitle(event.getTitle()+" ["+bands.size()+"]" );
                event.setBands(bands);
                results.add(event);
            }
        }

        return results;
    }

    public Event updateEvent(Event event){
        return eventRepository.save(event);
    }
}
