package com.LocuraTech.locuraInit.Services;

import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    private MongoTemplate mongoTemplate;

    public UserServices(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    public UserModel getUserByName (String name){
        Query query = new Query().addCriteria(Criteria.where("name").is(name).regex("$regex", "i"));
        UserModel userFound = mongoTemplate.findOne(query, UserModel.class);
        return userFound;
    }
}
