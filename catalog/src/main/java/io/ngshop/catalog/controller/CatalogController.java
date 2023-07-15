package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.entity.Brand;
import io.ngshop.catalog.entity.Product;
import io.ngshop.catalog.entity.Type;
import io.ngshop.catalog.service.ProductService;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Catalog")
@Slf4j
public class CatalogController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String working() {
        return this.getClass().getName() + " working";
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("brands/{brandId}")
    public ResponseEntity<List<Product>> getProductsByBrandId(@PathVariable String brandId) {
        return productService.getProductsByBrandId(brandId);
    }

    @GetMapping("/GetAllProducts")
    public ResponseEntity<ProductDTO> getAllProducts(@RequestParam(required = false) String brandId) {
//        mongoTemplate.findOne(Criteria.where().is())
        if (brandId == null) {
            return ResponseEntity.ok(new ProductDTO(mongoTemplate.findAll(Product.class)));
        } else {
            log.info("brandId: {}", brandId);
            return ResponseEntity.ok(new ProductDTO(productService.getProductsByBrandId(brandId).getBody()));
        }
    }

    class ProductDTO {
        public ProductDTO() {
        }

        public ProductDTO(List<Product> data) {
            this.data = data;
        }

        private List<Product> data;

        public List<Product> getData() {
            return data;
        }

        public void setData(List<Product> data) {
            this.data = data;
        }
    }

    @GetMapping("/GetAllBrands")
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        return ResponseEntity.ok(mongoTemplate.findAll(Brand.class).stream()
                .map(b -> new BrandDTO(b.getId().toHexString(), b.getName()))
                .collect(Collectors.toList()));
    }

    class BrandDTO {
        private String id;
        private String name;

        public BrandDTO(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("/GetAllTypes")
    public ResponseEntity<List<Type>> getAllTypes() {
        return ResponseEntity.ok(mongoTemplate.findAll(Type.class));
    }
}
