package com.LocuraTech.locuraInit.UserRepository;

import com.LocuraTech.locuraInit.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

}
