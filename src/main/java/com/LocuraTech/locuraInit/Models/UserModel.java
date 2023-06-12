package com.LocuraTech.locuraInit.Models;


import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
public class UserModel {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;

    @DocumentReference(collection = "Publicaciones")
    private  List<PublicacionModel> postModel = new ArrayList<>();
    private String lastName;

    public UserModel(String name, String id, String email, String password, String phone, String address, String city, String state, String lastName, List<PublicacionModel> postModel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.lastName = lastName;
        this.postModel = postModel;
    }

    public UserModel() {
    }

    public List<PublicacionModel> getPostModel() {
        return postModel;
    }

    public void setPostModel(List<PublicacionModel> postModel) {
        this.postModel = postModel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postModel=" + postModel +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
