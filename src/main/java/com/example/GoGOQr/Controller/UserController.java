package com.example.GoGOQr.Controller;

import com.example.GoGOQr.Model.Status;
import com.example.GoGOQr.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
	
    @Autowired
    UserRep userRep;
    
    @PostMapping("/users/register")
    public ResponseEntity registerUser(@Valid @RequestBody User newUser) {
    	// Get users by email, we have to validate if user exists before create it
        List<User> users = (List<User>) userRep.findAllByEmailIgnoreCase(newUser.getEmail());
        // If there are user with same email. 
        if (users.size() > 0){
            System.out.println("User Already exists!");
            // TODO Update to JSON format
            System.out.println(Status.USER_ALREADY_EXISTS);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }
        userRep.save(newUser);
        System.out.println(Status.SUCCESS);

        // TODO Update to JSON format
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    
    @PostMapping("/users/login")
    public ResponseEntity loginUser(@RequestBody User loginUser) {
    	List<User> users = (List<User>) userRep.findAllByEmailIgnoreCase(loginUser.getEmail());
    	// First validate if user with that email exists, if there is no user, return error
    	// TODO Update to JSON format
    	if(users.size() == 0) {
            System.out.println(Status.FAILURE);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }
    	// Validate password, if is not valid return error
    	// TODO Update to JSON format
    	else if (users.get(0).getPassword().equals(loginUser.getPassword())) {
            System.out.println(Status.FAILURE);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    	// TODO Maybe we need to return something else, the user id or something like that
    	// TODO Update to JSON format
       else
           return new ResponseEntity<>(loginUser.getId(), HttpStatus.OK);
    }
    
    
    @PostMapping("/users/logout")
    public ResponseEntity logUserOut(@Valid @RequestBody User user) {
        List<User> users = (List<User>) userRep.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRep.save(user);
                System.out.println(Status.SUCCESS);
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        System.out.println(Status.FAILURE);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/users/delete/all")
    public ResponseEntity deleteUsers() {
        userRep.deleteAll();
        System.out.println(Status.SUCCESS);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users/all")
    public ResponseEntity getUsers(){
        List<User> users = (List<User>) userRep.findAll();
        if(users.size()>0)
            return new ResponseEntity(users,HttpStatus.OK);
        else return new ResponseEntity(0,HttpStatus.NO_CONTENT);
    }


}
