package com.sun.service.impl;

import com.sun.dataobject.ProductCategory;
import com.sun.repository.ProductCategoryRepository;
import com.sun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SqMax on 2018/3/17.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
