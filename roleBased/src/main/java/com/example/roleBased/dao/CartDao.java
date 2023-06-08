package com.example.roleBased.dao;

import com.example.roleBased.entity.CartDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends CrudRepository<CartDetails,Integer> {

}
