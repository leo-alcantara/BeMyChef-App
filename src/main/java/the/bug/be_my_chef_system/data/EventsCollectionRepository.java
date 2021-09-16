package the.bug.be_my_chef_system.data;
import the.bug.be_my_chef_system.data.model.Events;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public class EventsCollectionRepository implements EventsDAO {
    @Override
    public Collection<Events> findEventsByUserId(int userId) {
        return null;
    }

    @Override
    public Collection<Events> findEventsByChefId(int chefId) {
        return null;
    }

    @Override
    public Collection<Events> findByEventType(String eventType) {
        return null;
    }

    @Override
    public Collection<Events> findEventsByDate(LocalDate eventDate) {
        return null;
    }

    @Override
    public Collection<Events> findByEventAddress(String eventAddress) {
        return null;
    }

    @Override
    public Optional<Events> create(Events events) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Collection<Events> findAll() {
        return null;
    }

    @Override
    public Optional<Events> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean update(Events events) {
        return false;
    }

    @Override
    public void clear() {

    }
}
