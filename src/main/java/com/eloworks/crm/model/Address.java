package com.eloworks.crm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "address")
@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "idperson")
    private Person person;
    
    private String street;
    private String postcode;
    private String number;
    private String city;
    private boolean isprincipal;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public Person getPerson(){ return person; }  
    public void setPerson(Person person){ this.person = person; }

    public String getStreet(){ return street;}
    public void setStreet(String street){ this.street = street; }

    public String getPostcode(){ return postcode; }
    public void setPostcode(String postcode){ this.postcode = postcode;}

    public String getNumber(){ return number; }
    public void setNumber(String number){ this.number = number; }

    public String getCity(){ return city; }
    public void setCity(String city){ this.city = city; }

    public boolean getIsprincipal(){ return isprincipal; }
    public void setIsprincipal(boolean isprincipal){ this.isprincipal = isprincipal; }

}
