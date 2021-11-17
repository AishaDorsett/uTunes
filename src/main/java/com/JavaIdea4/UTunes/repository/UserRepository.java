package com.JavaIdea4.UTunes.repository;

import java.util.List;

import com.JavaIdea4.UTunes.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  List<User> findByUsername(String username);
}
