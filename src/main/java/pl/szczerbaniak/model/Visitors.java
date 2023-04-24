package pl.szczerbaniak.model;

import javax.persistence.*;

@Entity
@Table(name = "visitors")
public class Visitors {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String secondName;
    private String surname;
    private String pesel;
    private String nameOfIdentityDocument;
    private String numberOfIdentityDocument;
    private String email;
    private String phoneNumber;
    private String schoolName;
    private String locality;
    private String major;
    private String choiceNumber;

    public Visitors() {
    }

    public Visitors(Long id, String name, String secondName, String surname, String pesel, String nameOfIdentityDocument, String numberOfIdentityDocument, String email, String phoneNumber, String schoolName, String locality, String major, String choiceNumber) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.pesel = pesel;
        this.nameOfIdentityDocument = nameOfIdentityDocument;
        this.numberOfIdentityDocument = numberOfIdentityDocument;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.schoolName = schoolName;
        this.locality = locality;
        this.major = major;
        this.choiceNumber = choiceNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNameOfIdentityDocument() {
        return nameOfIdentityDocument;
    }

    public void setNameOfIdentityDocument(String nameOfIdentityDocument) {
        this.nameOfIdentityDocument = nameOfIdentityDocument;
    }

    public String getNumberOfIdentityDocument() {
        return numberOfIdentityDocument;
    }

    public void setNumberOfIdentityDocument(String numberOfIdentityDocument) {
        this.numberOfIdentityDocument = numberOfIdentityDocument;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(String choiceNumber) {
        this.choiceNumber = choiceNumber;
    }
}
