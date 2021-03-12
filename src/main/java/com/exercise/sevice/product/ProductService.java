package com.exercise.sevice.product;

import com.exercise.model.Category;
import com.exercise.model.Product;
import com.exercise.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<Product> findAllPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findProductName(String name) {
        name = "%" + name + "%";
        return productRepository.findProductName(name);
    }

    @Override
    public List<Product> findAllByCategory(Category name) {
        return productRepository.findAllByCategory(name);
    }

    @Override
    public List<Product> findTop5Date() {
        return productRepository.findTop5ByOrderByPriceDesc();
    }
}
