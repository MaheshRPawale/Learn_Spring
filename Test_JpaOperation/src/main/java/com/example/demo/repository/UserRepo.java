package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Mahesh;
@Repository
public interface UserRepo extends JpaRepository<Mahesh, Integer> {

}
