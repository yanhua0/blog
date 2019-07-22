package org.url.service;

import org.url.entity.Myblog;

import java.util.List;

public interface MyblogService {
    void save(Myblog myblog);
    Myblog findById(int id);
    void delete(Myblog myblog);
    List<Myblog> findAll();
    List<Myblog> findByTitle(Myblog myblog);
    Myblog findByURL(Myblog myblog);
}
