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
                if(!members.isEmpty()){
                    //It is needed to use a tmp object here to avoid duplication of the length information
                    Band tmpBand = new Band(band);
                    tmpBand.setName(tmpBand.getName()+" ["+members.size()+"]");
                    tmpBand.setMembers(members);
                    bands.add(tmpBand);
                }
            }
            if(!bands.isEmpty()){
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
