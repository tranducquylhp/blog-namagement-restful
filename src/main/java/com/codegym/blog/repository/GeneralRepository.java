package com.codegym.blog.repository;

import java.util.List;

public interface GeneralRepository<E> {
    List<E> findAll();
}
