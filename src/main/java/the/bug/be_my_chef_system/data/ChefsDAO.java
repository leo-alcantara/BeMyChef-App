package the.bug.be_my_chef_system.data;


import the.bug.be_my_chef_system.model.Chefs;
import the.bug.be_my_chef_system.model.Events;

import java.util.Collection;

public interface ChefsDAO extends GenericDAO <Chefs, String> {

    Chefs findChefsByUsername(String chefUsername);

    Collection<Chefs> findChefsByFirstName(String chefName);

    Collection<Chefs> findChefsByArea(String area);

    Chefs findChefsByHomeAddress(String homeAddress);

    Collection<Chefs> findChefsByEvent(Events event);


}
