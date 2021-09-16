package the.bug.be_my_chef_system.data;


import the.bug.be_my_chef_system.data.model.Users;

import java.util.Collection;
import java.util.Optional;

public class UsersCollectionRepository implements UsersDAO {
    @Override
    public Optional<Users> create(Users users) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Collection<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean update(Users users) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Users findUsersByUsername(String userUsername) {
        return null;
    }

    @Override
    public Collection<Users> findUsersByName(String userName) {
        return null;
    }

    @Override
    public Collection<Users> findUsersByHomeAddress(String homeAddress) {
        return null;
    }
}
