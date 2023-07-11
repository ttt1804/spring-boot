package com.example.uploadmultiplefiles.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name = "document")
    private String document;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        if (profilePicture == null || id == null) return null;

        return "candidates/" + id + "/" + profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPhotoId() {
        if (photoId == null || id == null) return null;

        return "candidates/" + id + "/" + photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getDocument() {
        if (document == null || id == null) return null;

        return "candidates/" + id + "/" + document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}