package com.LocuraTech.locuraInit.UserRepository;

import com.LocuraTech.locuraInit.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    @Query("{'name': {'$regex': '?0', '$options': 'i'}}")
    ArrayList<UserModel> getUser(String name);
}
