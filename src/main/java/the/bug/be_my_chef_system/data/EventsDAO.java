package the.bug.be_my_chef_system.data;


import the.bug.be_my_chef_system.data.model.Events;

import java.time.LocalDate;
import java.util.Collection;

public interface EventsDAO extends GenericDAO <Events, Integer> {

    //Events createEvent (Events event);

    //Collection<Events> findAllEvents ();

    //Events findEventsById (int eventId);

    Collection<Events> findEventsByUserId (int userId);

    Collection<Events> findEventsByChefId(int chefId);

    Collection<Events> findByEventType (String eventType);

    Collection<Events> findEventsByDate (LocalDate eventDate);

    Collection<Events> findByEventAddress (String eventAddress);

   // Events updateEvents (Events event);

    //boolean deleteEventsById(int eventId);

    //void clearEvents();
}
