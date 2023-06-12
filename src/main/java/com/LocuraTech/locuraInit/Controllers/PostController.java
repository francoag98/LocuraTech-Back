package com.LocuraTech.locuraInit.Controllers;

import com.LocuraTech.locuraInit.Models.PublicacionModel;
import com.LocuraTech.locuraInit.Models.UserModel;
import com.LocuraTech.locuraInit.Services.PostServices;
import com.LocuraTech.locuraInit.Services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
            ObjectId idMongodb = new ObjectId(id);
            if (idMongodb.toString().isEmpty() | idMongodb.toString().length() != 24){
                return new ResponseEntity<String>("El id proporcionado es invalido" , HttpStatus.FORBIDDEN);
            }else {
                UserModel users = userServices.getUserById(String.valueOf(idMongodb));
                if(users == null){
                    return new ResponseEntity<String>("No existe el usuario con ese Id" , HttpStatus.FORBIDDEN);
                }
                PublicacionModel createPost2 = postServices.saveUser(body);
                createPost2.setUser(users.getId());
                createPost2.setCreatedAt(new Date());
                postServices.saveUser(createPost2);
                users.getPostModel().add(createPost2);
                userServices.saveUser(users);
                return new ResponseEntity<PublicacionModel>(createPost2, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getPosts(){
        try{
            ArrayList<PublicacionModel> posts = postServices.getPublis();
            if (posts.size() == 0){
                return new ResponseEntity<String>("No hay ninguna publicacion de momento", HttpStatus.FORBIDDEN);
            }
            return new ResponseEntity<ArrayList<PublicacionModel>>(posts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
