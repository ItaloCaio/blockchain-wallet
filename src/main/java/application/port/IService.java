package application.port;


public interface IService<T> {

    T add(T item);

    Iterable<T> getAll();

    T getById(Long id);

    T update(T item);

    T remove(T item);

    int count();

}
