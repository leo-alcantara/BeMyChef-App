package the.bug.be_my_chef_system.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Chefs {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String chefId;
    private String chefsBio;
    private short chefRating;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person personChef;
    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "chefs_and_events",
            joinColumns = @JoinColumn(name = "chef_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Collection<Events> events;

    public Chefs() {
    }

    public Chefs(String chefsBio, short chefRating, Person personChef) {
        this.chefsBio = chefsBio;
        this.chefRating = chefRating;
        this.personChef = personChef;
    }

    //Convenience Methods
    public void addEvent(Events event){
        events.add(event);
        event.getResponsibleChef().add(this);
    }

  /*  public void removeEvent (Events event){
        event.getResponsibleChef().remove(this);
        events.remove(event);
    }*/

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getChefsBio() {
        return chefsBio;
    }

    public void setChefsBio(String chefsBio) {
        this.chefsBio = chefsBio;
    }

    public short getChefRating() {
        return chefRating;
    }

    public void setChefRating(short chefRating) {
        this.chefRating = chefRating;
    }

    public Person getPersonChef() {
        return personChef;
    }

    public void setPersonChef(Person personChef) {
        this.personChef = personChef;
    }

    public Collection<Events> getEvents() {
        return events;
    }

    public void setEvents(Collection<Events> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chefs chefs = (Chefs) o;
        return getChefRating() == chefs.getChefRating() && Objects.equals(getChefsBio(), chefs.getChefsBio()) && Objects.equals(getPersonChef(), chefs.getPersonChef());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChefsBio(), getChefRating(), getPersonChef());
    }

    @Override
    public String toString() {
        return "Chefs{" +
                "chefId='" + chefId + '\'' +
                ", chefsBio='" + chefsBio + '\'' +
                ", chefRating=" + chefRating +
                ", personChef=" + personChef +
                '}';
    }
}
