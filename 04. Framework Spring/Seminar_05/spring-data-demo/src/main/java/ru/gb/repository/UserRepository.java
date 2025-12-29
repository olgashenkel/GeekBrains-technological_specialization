package ru.gb.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//public interface UserRepository extends CrudRepository<User, Long> {
//}


public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    List<User> findAllByName(String name);

//    List<String> findNameById(Long id);

    List<User> findByNameOrAge(String name, Integer age);

    List<User> findByAgeGreaterThan(Pageable pageable, int value);
}

