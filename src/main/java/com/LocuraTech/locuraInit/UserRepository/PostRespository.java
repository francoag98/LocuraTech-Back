package com.LocuraTech.locuraInit.UserRepository;

import com.LocuraTech.locuraInit.Models.PublicacionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends MongoRepository<PublicacionModel, String> {
}
