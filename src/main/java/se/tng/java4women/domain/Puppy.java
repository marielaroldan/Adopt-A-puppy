package se.tng.java4women.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

import javax.validation.constraints.Size;

@Entity
public class Puppy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Size(max = 45)
    private String puppyname;
    
    @Size(max = 45)
    private String breed;
    
    @Size(max = 45)
    private String gender;
    private Date dateofbirth;
    private String size; 
    
    @Size(min=5,max=50,message = "Picture must be a valid path")
    private String picture;

    public Puppy(String puppyname, String breed, String gender, Date dateofbirth, String size, String picture) {
        this.puppyname = puppyname;
        this.breed = breed;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.size = size;
        this.picture = picture;
    }  

    public Puppy() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.puppyname);
        hash = 53 * hash + Objects.hashCode(this.breed);
        hash = 53 * hash + Objects.hashCode(this.gender);
        hash = 53 * hash + Objects.hashCode(this.dateofbirth);
        hash = 53 * hash + Objects.hashCode(this.size);
        hash = 53 * hash + Objects.hashCode(this.picture);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puppy other = (Puppy) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.puppyname, other.puppyname)) {
            return false;
        }
        if (!Objects.equals(this.breed, other.breed)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.picture, other.picture)) {
            return false;
        }
        if (!Objects.equals(this.dateofbirth, other.dateofbirth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Puppy {" + id + ", " + puppyname + " " + breed + " " + gender + " " + picture + " " + size + "}";
    }
}
