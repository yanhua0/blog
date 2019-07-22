package org.url.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.url.entity.Myblog;

import java.util.List;

public interface MyblogDao extends JpaRepository<Myblog, Integer> {
    List<Myblog> findByTitleContainingOrderByCreateTimeDesc(String title);
    List<Myblog> findAllByOrderByCreateTimeDesc();
    Myblog findByUrl(String url);
}
