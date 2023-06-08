package com.LocuraTech.locuraInit.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.Optional;

@Document(collection = "Publicaciones")
public class PublicacionModel {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @DocumentReference(collection = "Users")
    private Optional<UserModel> user;
    private Date createdAt;
    private String title;
    private String description;
    private String image;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PublicacionModel{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public PublicacionModel() {
    }

    public PublicacionModel(String id, UserModel user, Date createdAt, String title, String description, String image) {
        this.id = id;
        this.user = Optional.ofNullable(user);
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Optional<UserModel> getUser() {
        return user;
    }

    public void setUser(Optional<UserModel> user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
