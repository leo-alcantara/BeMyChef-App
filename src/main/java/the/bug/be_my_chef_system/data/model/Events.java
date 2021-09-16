package the.bug.be_my_chef_system.data.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Events {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String  eventId;
    private String eventType; //Breakfast, Lunch or Dinner
    private int numberOfGuests;
    private LocalDate eventDate;
    private String eventAddress;
    private boolean done;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "chefs_and_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "chef_id"))
    private Collection<Chefs> responsibleChef;

    public Events() {
    }

    public Events(String eventType, int numberOfGuests, LocalDate eventDate, String eventAddress, Users user) {
        this.eventType = eventType;
        this.numberOfGuests = numberOfGuests;
        this.eventDate = eventDate;
        this.eventAddress = eventAddress;
        this.user = user;
    }

    public Events(String eventType, int numberOfGuests, LocalDate eventDate, String eventAddress, Users user, Collection<Chefs> responsibleChef) {
        this.eventType = eventType;
        this.numberOfGuests = numberOfGuests;
        this.eventDate = eventDate;
        this.eventAddress = eventAddress;
        this.user = user;
        this.responsibleChef = responsibleChef;
    }

    //Convenience Method
    public void addChef (Chefs chef){
        responsibleChef.add(chef);
        chef.getEvents().add(this);
    }

    public void eventCompleted (Events event){
        event.setDone(true);
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Collection<Chefs> getResponsibleChef() {
        return responsibleChef;
    }

    public void setResponsibleChef(Collection<Chefs> responsibleChef) {
        this.responsibleChef = responsibleChef;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return getNumberOfGuests() == events.getNumberOfGuests() && Objects.equals(getEventType(), events.getEventType()) && Objects.equals(getEventDate(), events.getEventDate()) && Objects.equals(getEventAddress(), events.getEventAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventType(), getNumberOfGuests(), getEventDate(), getEventAddress());
    }

    @Override
    public String toString() {
        return "Events{" +
                "eventType='" + eventType + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                ", eventDate=" + eventDate +
                ", eventAddress='" + eventAddress + '\'' +
                ", user=" + user +
                '}';
    }
}
