package com.codegym.blog.service;

import com.codegym.blog.model.BlogCategoryName;
import com.codegym.blog.model.Category;
import com.codegym.blog.model.CategoryNoBlogName;

import java.util.List;

public interface CategoryService extends GeneralService<Category>{
    List<BlogCategoryName> findAllByCategory(long id);
    List<CategoryNoBlogName> fincAllNoBlogName();
}
