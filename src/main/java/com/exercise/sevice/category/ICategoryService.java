package com.exercise.sevice.category;

import com.exercise.model.Category;
import com.exercise.model.Product;
import com.exercise.sevice.IService;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    Category findByName (String name);
}
