package org.url.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.url.dao.ZhaoPinDao;
import org.url.entity.ZhaoPin;
import org.url.service.ZhaoPinService;

import java.util.List;
@Service
public class ZhaoPinServiceImpl implements ZhaoPinService {
    @Autowired
    private ZhaoPinDao zhaoPinDao;
    @Override
    public void save(ZhaoPin zp) {
        zhaoPinDao.save(zp);
    }

    @Override
    public ZhaoPin findById(int id) {
       return zhaoPinDao.findById(id).get();
    }

    @Override
    public void delete(ZhaoPin zp) {
      zhaoPinDao.delete(zp);
    }

    @Override
    public List<ZhaoPin> findAll() {
      return  zhaoPinDao.findAllByOrderByCreateTimeDesc();
    }

    @Override
    public List<ZhaoPin> findByTitle(ZhaoPin zp) {
        return zhaoPinDao.findByTitleContainingOrderByCreateTimeDesc(zp.getTitle());
    }

    @Override
    public ZhaoPin findByURL(ZhaoPin zp) {
        return zhaoPinDao.findByUrl(zp.getUrl());
    }
}
