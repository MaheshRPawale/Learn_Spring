package com.example.demo.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.OrderEntity;
@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
