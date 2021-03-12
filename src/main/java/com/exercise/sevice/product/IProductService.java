package com.exercise.sevice.product;

import com.exercise.model.Category;
import com.exercise.model.Product;
import com.exercise.sevice.IService;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> findProductName (String name);
    List<Product> findAllByCategory (Category name);
}
