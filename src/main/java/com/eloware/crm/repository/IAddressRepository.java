package com.eloware.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.eloware.crm.model.Address;



@Repository
public interface IAddressRepository extends JpaRepository<Address, Long>{

    List<Address> findByPerson_Id(Long idperson);
    
}
