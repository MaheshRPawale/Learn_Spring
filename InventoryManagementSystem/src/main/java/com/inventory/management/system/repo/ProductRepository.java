package com.inventory.management.system.repo;

import com.inventory.management.system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByQuantityLessThan(Integer threshold);


}
/*findBy → tells Spring to search

Quantity → the field to check

LessThan → comparison operator

(Integer threshold) → value you pass at runtime*/