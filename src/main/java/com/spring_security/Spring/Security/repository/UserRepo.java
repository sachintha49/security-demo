package com.spring_security.Spring.Security.repository;

import com.spring_security.Spring.Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findByEmail(String username);
}
