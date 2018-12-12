package com.Dispather.My.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dispather.My.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable>
{

}
