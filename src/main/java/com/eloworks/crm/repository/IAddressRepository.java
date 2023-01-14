package com.eloworks.crm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.eloworks.crm.model.Address;



@Repository
public interface IAddressRepository extends JpaRepository<Address, Long>{

    List<Address> findByPerson_Id(Long idperson);
    
}