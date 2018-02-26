/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.tng.java4women.controllers;

import se.tng.java4women.dataaccess.DataAccessPuppies;
import se.tng.java4women.domain.Puppy;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marie
 */
@Named(value = "updatecontroller")
@RequestScoped
public class UpdateController implements Serializable {

    @Inject
    DataAccessPuppies dao;

    private Integer id;
    private String puppyname;
    private String breed;
    private String gender;
    private Date dateofbirth;
    private String size;
    private String picture;
    private List<Puppy> allPuppies = new ArrayList<>();

    private Puppy puppy = new Puppy();

    public UpdateController() {
        System.out.println("creado");
    }
    
    @PostConstruct
    public void init(){
        allPuppies = dao.showAllpuppies();
    }
    
    public Puppy getPuppy() {
        return puppy;
    }

    public void setPuppy(Puppy puppy) {
        this.puppy = puppy;
    }

    public DataAccessPuppies getDao() {
        return dao;
    }

    public void setDao(DataAccessPuppies dao) {
        this.dao = dao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Puppy> getAllPuppies() {
        return allPuppies;
    }

    public void setAllPuppies(List<Puppy> allPuppiess) {
        this.allPuppies = allPuppiess;
    }

    public void findById() {
        System.out.println("Buscando id: " + id);
        puppy = dao.getPuppyById(id);
    }

    public String update() {
        Puppy puppy2 = dao.getPuppyById(id);

        puppy2.setPuppyname(puppy.getPuppyname());
        puppy2.setBreed(puppy.getBreed());
        puppy2.setGender(puppy.getGender());
        puppy2.setDateofbirth(puppy.getDateofbirth());
        puppy2.setSize(puppy.getSize());
        puppy2.setPicture(puppy.getPicture());

        dao.updatePuppies(puppy2);
        return "updatePuppies";
    }

}
