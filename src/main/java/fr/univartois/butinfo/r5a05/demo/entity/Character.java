package fr.univartois.butinfo.r5a05.demo.entity;

import jakarta.persistence.*;

import java.net.URI;
import java.time.Year;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @Column
    String gender;

    @Column
    String country;

    @Column
    Integer nbAlbums;

    @Column
    Year creationYear;

    @Column
    URI image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNbAlbums() {
        return nbAlbums;
    }

    public void setNbAlbums(Integer nbAlbums) {
        this.nbAlbums = nbAlbums;
    }

    public Year getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(Year creationYear) {
        this.creationYear = creationYear;
    }

    public URI getImage() {
        return image;
    }

    public void setImage(URI image) {
        this.image = image;
    }
}