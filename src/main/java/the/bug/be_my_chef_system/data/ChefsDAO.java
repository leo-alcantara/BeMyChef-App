package the.bug.be_my_chef_system.data;


import the.bug.be_my_chef_system.data.model.Chefs;

import java.util.Collection;

public interface ChefsDAO extends GenericDAO <Chefs, Integer> {

    //Chefs createChef(Chefs chef);

    //Collection<Chefs> findAllChefs();

    //Chefs findChefsById(int chefId);

    Chefs findChefsByUsername(String chefUsername);

    Collection<Chefs> findChefsByFirstName(String chefName);

    Collection<Chefs> findChefsByArea(String area);

    Chefs findChefsByHomeAddress(String homeAddress);

    //Chefs updateChefs(Chefs chef);

    //boolean deleteChefsById(int chefId);

    //void clearChefs();
}
