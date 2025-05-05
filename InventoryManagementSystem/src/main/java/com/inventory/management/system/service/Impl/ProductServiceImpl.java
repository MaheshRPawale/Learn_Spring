package com.inventory.management.system.service.Impl;

import com.inventory.management.system.entity.Product;
import com.inventory.management.system.repo.ProductRepository;
import com.inventory.management.system.requestdto.ProductRequestDTO;
import com.inventory.management.system.responsedto.ProductResponseDTO;
import com.inventory.management.system.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    // dto to entity .
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {

        Product product=modelMapper.map(dto,Product.class);
        //Yahan dto ko Product entity me convert kiya ja raha hai.
        //DTO sirf data carry karta hai, lekin database me save karne ke liye Product entity chahiye.
        product =productRepository.save(product);
        //Yahan product entity ko database me save kiya ja raha hai.save() method JPA ka hai, jo object ko DB me insert/update karta hai.
        //Save ke baad updated product return hota hai (jisme ID, timestamps jaise fields bhar jaate hain).
        return modelMapper.map(product, ProductResponseDTO.class);
        //Database me save hone ke baad entity ko wapas ProductResponseDTO me convert kar diya gaya.
        //
        //Ye response DTO client ko bhejna hota hai — entity direct nahi bhejte for security & data hiding.
    }


    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
       Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found with id"+id));
        return modelMapper.map(product,ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product existingProduct=productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        // Map updated fields from DTO to existing entity
        modelMapper.map(dto, existingProduct);

        Product updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductResponseDTO.class);

    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDTO> getLowStockProducts(int threshold) {
        List<Product> lowStockProducts = productRepository.findByQuantityLessThan(threshold);
        return lowStockProducts.stream()
                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());

    }
}
