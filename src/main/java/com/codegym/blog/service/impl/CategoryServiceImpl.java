package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.BlogCategoryName;
import com.codegym.blog.model.Category;
import com.codegym.blog.model.CategoryNoBlogName;
import com.codegym.blog.repository.CategoryRepository;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<BlogCategoryName> findAllByCategory(long id) {
        List<Blog> blogs = categoryRepository.findAllByCategory(id);
        return getBlogCategoryNames(blogs);
    }

    private List<BlogCategoryName> getBlogCategoryNames(List<Blog> blogs) {
        List<BlogCategoryName> blogCategoryNames = new ArrayList<>();
        for (int i=0; i<blogs.size(); i++){
            Blog blog = blogs.get(i);
            blogCategoryNames.add(new BlogCategoryName(blog.getId(),blog.getTitle(),blog.getDescription(), blog.getContent(), blog.getDateCreate(), blog.getCategory().getName()));
        }
        return blogCategoryNames;
    }

    @Override
    public List<CategoryNoBlogName> fincAllNoBlogName() {
        return getCategoryNoBlogName(findAll());
    }

    private List<CategoryNoBlogName> getCategoryNoBlogName(List<Category> categories) {
        List<CategoryNoBlogName> categoryNoBlogNames = new ArrayList<>();
        for (int i=0; i<categories.size(); i++){
            Category category = categories.get(i);
            categoryNoBlogNames.add(new CategoryNoBlogName(category.getId(), category.getName()));
        }
        return categoryNoBlogNames;
    }
}
