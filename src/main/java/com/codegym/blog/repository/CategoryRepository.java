package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;

import java.util.List;

public interface CategoryRepository extends GeneralRepository<Category> {
    List<Blog> findAllByCategory(long id);
}
