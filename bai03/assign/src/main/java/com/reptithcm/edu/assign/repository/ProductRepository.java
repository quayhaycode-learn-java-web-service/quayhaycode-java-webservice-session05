package com.reptithcm.edu.assign.repository;

import com.reptithcm.edu.assign.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



    void removeProductById(Long id);
}
