package com.kolesnyk.dao;

import com.kolesnyk.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
