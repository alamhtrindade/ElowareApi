package com.eloware.crm.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "person")
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String birthdate;
    
    @OneToMany(mappedBy = "person")
    private List<Address> address;

    public Long getId(){ return id; } 
    public void setId(Long id){ this.id = id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name;  }

    public String getBirthdate(){ return birthdate; }
    public void setBirthdate(String birthdate){ this.birthdate = birthdate; }
    
}
