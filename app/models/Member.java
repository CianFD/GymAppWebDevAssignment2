package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Member extends Model {
    public String name;
    public String email;
    public String password;
    public String address;
    public String gender;
    public double height;
    public double startingWeight;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessments = new ArrayList<Assessment>();
    public void sortAssessments(Assessment assessment) {
        Collections.reverse(assessments);
    }
    public Member(String name, String email, String password, String address, String gender, double height, double startingWeight) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setAddress(address);
        setGender(gender);
        setHeight(height);
        setStartingWeight(startingWeight);
    }
    public static Member findByEmail(String email) {
        return find("email", email).first();
    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if ((gender.equals("Male")) || (gender.equals("Female"))) {
            this.gender = gender;
        }
        else {
            this.gender = "Unspecified";
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }
}
