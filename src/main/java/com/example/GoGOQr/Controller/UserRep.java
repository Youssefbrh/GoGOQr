package com.example.GoGOQr.Controller;
import com.example.GoGOQr.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRep extends CrudRepository<User, Long> , JpaSpecificationExecutor<User> {
	// Search users by email ignoring case
    List<User> findAllByEmailIgnoreCase(String email);
}
