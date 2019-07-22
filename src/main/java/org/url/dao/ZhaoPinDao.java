package org.url.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.url.entity.ZhaoPin;

import java.util.List;

public interface ZhaoPinDao extends JpaRepository<ZhaoPin, Integer> {
    List<ZhaoPin> findByTitleContainingOrderByCreateTimeDesc(String title);
    List<ZhaoPin> findAllByOrderByCreateTimeDesc();
     ZhaoPin findByUrl(String url);
}
