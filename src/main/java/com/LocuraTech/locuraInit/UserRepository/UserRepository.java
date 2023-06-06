package com.LocuraTech.locuraInit.UserRepository;

import com.LocuraTech.locuraInit.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, Long> {

}
