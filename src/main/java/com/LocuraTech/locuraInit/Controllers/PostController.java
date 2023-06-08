package com.LocuraTech.locuraInit.Controllers;

import com.LocuraTech.locuraInit.Models.PublicacionModel;
import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.Services.PostServices;
import com.LocuraTech.locuraInit.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    UserServices userServices;
    @Autowired
    PostServices postServices;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PublicacionModel body, @RequestParam("id") String id){
        try{
            PublicacionModel createPost2 = postServices.saveUser(body);
            UserModel user = userServices.getUserById(id);
            if (user.getId().isEmpty()){
                return new ResponseEntity<String>("no existe el usuario con el id: " + id, HttpStatus.FORBIDDEN);
            }
            createPost2.setUser(Optional.of(user));
            createPost2.setCreatedAt(new Date());
            user.setPublicacionModel(createPost2);
            return new ResponseEntity<PublicacionModel>(createPost2, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
