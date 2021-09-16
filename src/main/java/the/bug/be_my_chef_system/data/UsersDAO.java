package the.bug.be_my_chef_system.data;


import the.bug.be_my_chef_system.model.Users;

import java.util.Collection;

public interface UsersDAO extends GenericDAO <Users, String> {

    Users findUsersByUsername(String userUsername);

    Collection<Users> findUsersByName(String userName);

    Collection<Users> findUsersByHomeAddress(String homeAddress);


}
