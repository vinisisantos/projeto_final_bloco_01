package Model_Repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> getAll();

    void add(T entity);

    void update(String id, T updatedEntity);

    boolean remove(String id);

    T getById(String id);
}
