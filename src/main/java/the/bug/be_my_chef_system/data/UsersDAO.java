package the.bug.be_my_chef_system.data;


import the.bug.be_my_chef_system.data.model.Users;

import java.util.Collection;

public interface UsersDAO extends GenericDAO <Users, Integer> {

    //Users createUser(Users user);

   // Collection<Users> findAllUsers();

    //Users findUsersById(int userId);

    Users findUsersByUsername(String userUsername);

    Collection<Users> findUsersByName(String userName);

    Collection<Users> findUsersByHomeAddress(String homeAddress);

    //Users updateUsers(Users user);

   // boolean deleteUsersById(int userId);

    //void clearUsers();
}
