package the.bug.be_my_chef_system.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;
    private int userRating;
    private int fidelityPoints;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person personClient;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<Events> events;

    public Users() {
    }

    public Users(int userRating, int fidelityPoints, Person personClient) {
        this.userRating = userRating;
        this.fidelityPoints = fidelityPoints;
        this.personClient = personClient;
    }

    //Convenience Method
    public void addEvent (Events event){
        events.add(event);
        event.setUser(this);
    }

    public void removeEvent (Events event){
        event.setUser(null);
        events.remove(event);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public int getFidelityPoints() {
        return fidelityPoints;
    }

    public void setFidelityPoints(int fidelityPoints) {
        this.fidelityPoints = fidelityPoints;
    }

    public Person getPersonClient() {
        return personClient;
    }

    public void setPersonClient(Person personClient) {
        this.personClient = personClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return getUserRating() == users.getUserRating() && getFidelityPoints() == users.getFidelityPoints() && Objects.equals(getPersonClient(), users.getPersonClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserRating(), getFidelityPoints(), getPersonClient());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", userRating=" + userRating +
                ", fidelityPoints=" + fidelityPoints +
                ", personClient=" + personClient +
                '}';
    }
}
