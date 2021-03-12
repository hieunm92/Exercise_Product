package com.exercise.sevice.category;

import com.exercise.model.Category;
import com.exercise.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findOne(id);
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<Category> findAllPage(Pageable pageable) {
        return null;
    }

    @Override
    public Category findByName(String name) {
        return iCategoryRepository.findByName(name);
    }
}

