package repository;

import java.util.Set;

public interface Repository<T> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    Set<T> findAll();

}
