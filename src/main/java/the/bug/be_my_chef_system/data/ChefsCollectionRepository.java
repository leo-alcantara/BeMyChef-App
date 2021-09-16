package the.bug.be_my_chef_system.data;



import the.bug.be_my_chef_system.data.model.Chefs;

import java.util.Collection;
import java.util.Optional;

public class ChefsCollectionRepository implements ChefsDAO {
    @Override
    public Chefs findChefsByUsername(String chefUsername) {
        return null;
    }

    @Override
    public Collection<Chefs> findChefsByFirstName(String chefName) {
        return null;
    }

    @Override
    public Collection<Chefs> findChefsByArea(String area) {
        return null;
    }

    @Override
    public Chefs findChefsByHomeAddress(String homeAddress) {
        return null;
    }

    @Override
    public Optional<Chefs> create(Chefs chefs) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Collection<Chefs> findAll() {
        return null;
    }

    @Override
    public Optional<Chefs> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean update(Chefs chefs) {
        return false;
    }

    @Override
    public void clear() {

    }
}
