package seminar_03.homework.task_04;

import java.util.List;

public interface DatabaseInterface<T> {

    T save(T entity);

    void delete(Long id);

    T getById(Long id);

    List<T> getAll();
}
