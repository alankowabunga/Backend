package com.alan.springboot.course_first_webapp.UserSystem.Repository;

import com.alan.springboot.course_first_webapp.UserSystem.Model.Todo;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findTodosByUsername(String username);

    void deleteById(Long id);
}
