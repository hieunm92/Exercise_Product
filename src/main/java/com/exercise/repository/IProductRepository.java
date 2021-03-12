package com.exercise.repository;

import com.exercise.model.Category;
import com.exercise.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByOrderByIdAsc(Pageable pageable);

    @Query(value = "select * " +
            "from Product " +
            "where Product.name like ?", nativeQuery = true)
    List<Product> findProductName (String name);

    List<Product> findAllByCategory(Category name);
}
