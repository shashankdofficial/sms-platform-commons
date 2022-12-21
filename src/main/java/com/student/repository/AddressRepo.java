package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Address;

public interface AddressRepo  extends JpaRepository<Address, Integer>{

}
