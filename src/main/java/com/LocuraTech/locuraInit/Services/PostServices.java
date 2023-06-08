package com.LocuraTech.locuraInit.Services;

import com.LocuraTech.locuraInit.Models.PublicacionModel;
import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.UserRepository.PostRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServices {
    @Autowired
    PostRespository postRespository;

    public PublicacionModel saveUser(PublicacionModel body){
        return postRespository.save(body);
    }
}
