package app.application.port;


public interface IService<T> {

    T add(T item);

    Iterable<T> getAll();

    T getById(Long id);

    T update(T item);

    void remove(Long id);

    int count();

}
