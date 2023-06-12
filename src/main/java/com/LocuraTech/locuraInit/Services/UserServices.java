package com.LocuraTech.locuraInit.Services;

import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServices{
    @Autowired
    UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public UserServices(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public UserModel getUserById (String id){
        return mongoTemplate.findById(id, UserModel.class);
    }

    public ArrayList<UserModel> getUserByNameIndiferent(String name) {
        return userRepository.getUser(name);
    }
}
