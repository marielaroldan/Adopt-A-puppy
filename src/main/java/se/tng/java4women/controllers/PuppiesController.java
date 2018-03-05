package se.tng.java4women.controllers;

import se.tng.java4women.dataaccess.DataAccessPuppies;
import se.tng.java4women.domain.Puppy;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Named(value = "puppiescontroller")
//@RequestScoped
//@SessionScoped
@ViewScoped
public class PuppiesController implements Serializable {

    @Inject
    DataAccessPuppies dao;

    private long id;
    private String puppyname;
    private String breed;
    private String gender;
    private Date dateofbirth;
    private String size;
    private String picture;
    private Puppy editPuppy = new Puppy();
    private Puppy puppy = new Puppy();
    private List<?> allPuppies = new ArrayList<>();

    public Puppy getEditPuppy() {
        return editPuppy;
    }

    public void setEditPuppy(Puppy puppy2) {
        this.editPuppy = puppy2;
    }

    @PostConstruct
    public void init() {
        allPuppies = dao.showAllpuppies();
    }

    public PuppiesController() {
        puppy = new Puppy();
    }

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

    public Puppy getPuppy() {
        return puppy;
    }

    public void setPuppy(Puppy puppy) {
        this.puppy = puppy;
    }

    public void setDateofbirth(Date dateofbirth) throws ParseException {
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

    public List<?> getAllPuppies() {
        return allPuppies;
    }

    public void setAllPuppies(List<Puppy> allPuppiess) {
        this.allPuppies = allPuppiess;
    }

    public String addPuppy() {
        dao.addPuppy(puppy);
        return "puppiesconfirmation";
    }

    public String delete() {
        dao.deleteById(id);
        return "deletePuppies";
    }

    public void findById() {
        puppy = dao.getPuppyById(id);
    }

    public Puppy findById2() {
        System.out.println(editPuppy);
        return dao.getPuppyById(editPuppy.getId());
    }

    public String update() {
        
       puppy = findById2();
       
       puppy.setPuppyname(editPuppy.getPuppyname());
       puppy.setBreed(editPuppy.getBreed());
       puppy.setDateofbirth(editPuppy.getDateofbirth());
       puppy.setGender(editPuppy.getGender());
       puppy.setSize(editPuppy.getSize());
       puppy.setPicture(editPuppy.getPicture());
       dao.updatePuppies(puppy);
        return "puppiesList";
    }
}
