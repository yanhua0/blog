package org.url.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.url.dao.MyblogDao;
import org.url.entity.Myblog;
import org.url.service.MyblogService;

import java.util.List;

@Service
public class MyblogServiceImpl implements MyblogService {
    @Autowired
    private MyblogDao myblogDao;
    @Override
    public void save(Myblog myblog) {
        myblogDao.save(myblog);
    }

    @Override
    public Myblog findById(int id) {
       return myblogDao.findById(id).get();
    }

    @Override
    public void delete(Myblog myblog) {
       myblogDao.deleteById(myblog.getId());
    }

    @Override
    public List<Myblog> findAll() {
       return myblogDao.findAllByOrderByCreateTimeDesc();
    }

    @Override
    public List<Myblog> findByTitle(Myblog myblog) {
       return myblogDao.findByTitleContainingOrderByCreateTimeDesc(myblog.getTitle());
    }

    @Override
    public Myblog findByURL(Myblog myblog) {
        return myblogDao.findByUrl(myblog.getUrl());
    }
}
