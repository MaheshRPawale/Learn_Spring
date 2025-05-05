package com.inventory.management.system.service;

import com.inventory.management.system.entity.Product;
import com.inventory.management.system.requestdto.ProductRequestDTO;
import com.inventory.management.system.responsedto.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

      ProductResponseDTO createProduct(ProductRequestDTO dto);

       List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

      ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);

    void deleteProduct(Long id);

    List<ProductResponseDTO> getLowStockProducts(int threshold);
}
//Frontend User → sends data → ProductRequestDTO → Backend (Service Layer)
//Backend → saves it to DB → returns saved data → ProductResponseDTO → Client

// ProductRequestDTO dto → data is coming in (client is sending)
// ProductResponseDTO → data is going out (server is returning)