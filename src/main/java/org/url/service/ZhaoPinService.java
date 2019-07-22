package org.url.service;
import org.url.entity.ZhaoPin;

import java.util.List;

public interface ZhaoPinService {
    void save(ZhaoPin zp);
    ZhaoPin findById(int id);
    void delete(ZhaoPin zp);
    List<ZhaoPin> findAll();
    List<ZhaoPin> findByTitle(ZhaoPin zp);
    ZhaoPin findByURL(ZhaoPin zp);
}
