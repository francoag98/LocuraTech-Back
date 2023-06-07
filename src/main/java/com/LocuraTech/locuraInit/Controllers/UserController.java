package com.LocuraTech.locuraInit.Controllers;

import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        try {
            ArrayList<UserModel> users = userServices.getUsers();
            if (users.isEmpty()) {
                return new ResponseEntity<String>("no content", HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<ArrayList<UserModel>>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable("name") String name){
        try{
            UserModel userFound = userServices.getUserByName(name);
            return new ResponseEntity<UserModel>(userFound, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserModel user){
        try {
            String password = user.getPassword();
            UserModel userCreated = userServices.saveUser(user);
            return new ResponseEntity<UserModel>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
