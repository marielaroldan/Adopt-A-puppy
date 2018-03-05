/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.tng.java4women.controllers;

import se.tng.java4women.dataaccess.DataAccessPuppies;
import se.tng.java4women.domain.Puppy;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;


@Named(value = "registrationcontroller")
@RequestScoped
public class RegistrationController {
    
    @Inject
    DataAccessPuppies dao;

    private long id;
    private String puppyname;
    private String breed;
    private String gender;
    private Date dateofbirth;
    private String size;
    private String picture;

    public DataAccessPuppies getDao() {
        return dao;
    }

    public void setDao(DataAccessPuppies dao) {
        this.dao = dao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPuppyname() {
        return puppyname;
    }

    public void setPuppyname(String puppyname) {
        this.puppyname = puppyname;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String addPuppy(){
        Puppy puppy = new Puppy(puppyname, breed, gender, dateofbirth, size, picture);
        System.out.println(puppyname);
        dao.addPuppy(puppy);
        return "puppiesList";
    }   
    
}
