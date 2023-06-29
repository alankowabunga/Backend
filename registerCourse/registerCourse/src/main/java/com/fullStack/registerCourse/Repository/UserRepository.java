package com.fullStack.registerCourse.Repository;

import com.fullStack.registerCourse.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
