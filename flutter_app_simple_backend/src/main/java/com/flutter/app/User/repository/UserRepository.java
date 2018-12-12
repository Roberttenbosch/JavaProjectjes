package com.flutter.app.User.repository;

import com.flutter.app.User.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String>
{

}
