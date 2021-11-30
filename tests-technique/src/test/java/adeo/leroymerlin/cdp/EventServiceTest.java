/*

package adeo.leroymerlin.cdp;

import org.aspectj.lang.annotation.Before;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EventServiceTest {

    @InjectMocks
    private EventService eventService;

    @Mock
    private EventRepository eventRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEvents(){
        List<Event> events = new ArrayList<Event>();
        Event event = new Event();
        event.setId(1l);
        events.add(event);

        when(eventRepository.findAllBy()).thenReturn(events);

        List<Event> fetchedEvents = eventService.getEvents();

        verify(eventRepository).findAllBy();

        assertEquals(1l,events.get(0).getId());
    }

    @Test
    public void testGetFilteredEvents(){

        //==== Prepare datas ====

        List<Event> events = new ArrayList<Event>();

        Event eventVerifyOne = new Event();
        Event eventVerifyMultiple = new Event();
        Event eventNotVerify = new Event();

        Set<Band> bandsVerifyOne = new HashSet<Band>();
        Set<Band> bandsVerifyMultiple = new HashSet<Band>();
        Set<Band> bandsNotVerify = new HashSet<Band>();

        Band bandVerifyOne = new Band();
        Band bandVerifyTwo = new Band();
        Band bandNotVerify = new Band();

        Set<Member> membersVerifyOne = new HashSet<Member>();
        Set<Member> membersVerifyTwo = new HashSet<Member>();
        Set<Member> membersNotVerify = new HashSet<Member>();

        Member memberVerify1 = new Member();
        Member memberVerify2 = new Member();
        Member memberNotVerify = new Member();

        memberVerify1.setName("test toto");
        memberVerify2.setName("toto test");
        memberNotVerify.setName("titi");

        membersVerifyOne.add(memberVerify1);
        membersVerifyOne.add(memberNotVerify);
        membersVerifyTwo.add(memberVerify1);
        membersVerifyTwo.add(memberVerify2);
        membersVerifyTwo.add(memberNotVerify);
        membersNotVerify.add(memberNotVerify);

        bandVerifyOne.setMembers(membersVerifyOne);
        bandVerifyTwo.setMembers(membersVerifyTwo);
        bandNotVerify.setMembers(membersNotVerify);

        bandVerifyOne.setName("band1");
        bandVerifyTwo.setName("band2");
        bandNotVerify.setName("band3");

        bandsVerifyOne.add(bandVerifyOne);
        bandsVerifyOne.add(bandNotVerify);
        bandsVerifyMultiple.add(bandVerifyOne);
        bandsVerifyMultiple.add(bandVerifyTwo);
        bandsVerifyMultiple.add(bandNotVerify);
        bandsNotVerify.add(bandNotVerify);

        eventVerifyOne.setBands(bandsVerifyOne);
        eventVerifyMultiple.setBands(bandsVerifyMultiple);
        eventNotVerify.setBands(bandsNotVerify);

        eventVerifyOne.setTitle("eventVerifyOne");
        eventVerifyMultiple.setTitle("eventVerifyMultiple");
        eventNotVerify.setTitle("eventNotVerify");

        events.add(eventVerifyOne);
        events.add(eventVerifyMultiple);
        events.add(eventNotVerify);


        //==== Prepare result ====

        List<Event> expectedEvents = new ArrayList<Event>();

        Event expectedEventVerifyOne = new Event();
        Event expectedEventVerifyMultiple = new Event();

        Set<Band> expectedBandsVerifyOne = new HashSet<Band>();
        Set<Band> expectedBandsVerifyMultiple = new HashSet<Band>();

        Band expectedBandVerifyOne = new Band();
        Band expectedBandVerifyMultiple = new Band();

        Set<Member> expectedMembersVerifyOne = new HashSet<Member>();
        Set<Member> expectedMembersVerifyMultiple = new HashSet<Member>();

        expectedMembersVerifyOne.add(memberVerify1);
        expectedMembersVerifyMultiple.add(memberVerify1);
        expectedMembersVerifyMultiple.add(memberVerify2);

        expectedBandVerifyOne.setMembers(expectedMembersVerifyOne);
        expectedBandVerifyMultiple.setMembers(expectedMembersVerifyMultiple);

        expectedBandVerifyOne.setName("band1 [1]");
        expectedBandVerifyOne.setName("band2 [2]");

        expectedBandsVerifyOne.add(expectedBandVerifyOne);
        expectedBandsVerifyMultiple.add(expectedBandVerifyMultiple);


        expectedEventVerifyOne.setBands(expectedBandsVerifyOne);
        expectedEventVerifyMultiple.setBands(expectedBandsVerifyOne);
        expectedEventVerifyMultiple.setBands(expectedBandsVerifyMultiple);

        expectedEventVerifyOne.setTitle("eventVerifyOne [1]");
        expectedEventVerifyMultiple.setTitle("eventVerifyMultiple [2]");


    }
}


 */