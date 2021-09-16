package the.bug.be_my_chef_system.data;

import java.util.Collection;
import java.util.Optional;

public interface GenericDAO <T,ID>{

    Optional<T> create(T t);
    boolean delete(T t);
    Collection<T> findAll();
    Optional<T> findById(ID id);
    boolean update(T t);
    void clear();
}
