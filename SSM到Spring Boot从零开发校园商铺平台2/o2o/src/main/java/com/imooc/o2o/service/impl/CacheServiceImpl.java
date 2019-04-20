package com.imooc.o2o.service.impl;

import com.imooc.o2o.cache.JedisUtil;
import com.imooc.o2o.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-04-20 22:58
 */
public class CacheServiceImpl implements CacheService {
    @Autowired
    private JedisUtil.Keys jedisKeys;

    @Override
    public void removeFromCache(String keyPrefix) {
        Set<String> keySet = jedisKeys.keys(keyPrefix + "*");
        for(String key:keySet){
            jedisKeys.del(key);
        }
    }
}
