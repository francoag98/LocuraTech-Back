package com.LocuraTech.locuraInit.Models;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Date;

@Document(collection = "Publicaciones")
public class PublicacionModel {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    private String user;
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
                ", user='" + user + '\'' +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public PublicacionModel() {
    }

    public PublicacionModel(String id, String user, Date createdAt, String title, String description, String image) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
