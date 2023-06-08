package com.LocuraTech.locuraInit.Controllers;

import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserServices userServices;

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

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable("name") String name) {
        try{
            ArrayList<UserModel> userFound = userServices.getUserByNameIndiferent(name);
            if (userFound.size() == 0){
                return new ResponseEntity<String>("no se pudo obtener resultados", HttpStatus.FORBIDDEN);
            }
            return new ResponseEntity<ArrayList<UserModel>>(userFound, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.BAD_REQUEST);
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
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
        try{
            UserModel userFound = userServices.getUserById(id);
            if (userFound.getId().length() == 0){
                return new ResponseEntity<String>("no se pudo obtener resultados con el id: " + id, HttpStatus.FORBIDDEN);
            }else {
                return new ResponseEntity<UserModel>(userFound, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
