package com.example.demo.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonEntity;
@Repository
public interface personRepo  extends JpaRepository<PersonEntity, Integer>{

}
