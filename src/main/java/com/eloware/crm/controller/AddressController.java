package com.eloware.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eloware.crm.model.Address;
import com.eloware.crm.model.Person;
import com.eloware.crm.repository.IAddressRepository;
import com.eloware.crm.repository.IPersonRepository;

@RestController
@RequestMapping("/enderecos")
public class AddressController {
    
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private IPersonRepository personRepository;


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Address create(@PathVariable("id") Long id,@RequestBody Address address){
        
        Person person = personRepository.findById(id).get();
        address.setPerson(person);

        return addressRepository.save(address);
        
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Address> read(@PathVariable("id") Long id){

        return addressRepository.findByPerson_Id(id);

    }


    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Address address){
        
        return  addressRepository.findById(id).map(
                    record -> {
                        record.setStreet(address.getStreet());
                        record.setPostcode(address.getPostcode());
                        record.setNumber(address.getNumber());
                        record.setCity(address.getCity());
                        record.setIsprincipal(address.getIsprincipal());

                        Address addressUpdate = addressRepository.save(record);

                        return ResponseEntity.ok().body(addressUpdate);

                    }
                ).orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(path = {"/{id}"},method = RequestMethod.DELETE)
    public ResponseEntity <?> delete(@PathVariable Long id){
         
        return  addressRepository.findById(id).map(
                    record -> {
                        addressRepository.deleteById(id);
                        return ResponseEntity.ok().build();
                    }
                ).orElse(ResponseEntity.notFound().build());
    }
}
