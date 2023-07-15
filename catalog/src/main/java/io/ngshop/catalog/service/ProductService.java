package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.entity.Product;
import io.ngshop.catalog.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public ResponseEntity<Product> createProduct(Product productDto) {
        var product = productRepository.save(productDto);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<Product> getProductById(String productId) {
        return ResponseEntity.ok(productRepository.findById(new ObjectId(productId)).get());
    }

    public ResponseEntity<List<Product>> getProductsByBrandId(String brandId) {
        return ResponseEntity.ok(productRepository.findByBrandId(new ObjectId(brandId)));
    }
}
