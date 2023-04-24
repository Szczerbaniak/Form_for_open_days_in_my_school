package pl.szczerbaniak.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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


}
