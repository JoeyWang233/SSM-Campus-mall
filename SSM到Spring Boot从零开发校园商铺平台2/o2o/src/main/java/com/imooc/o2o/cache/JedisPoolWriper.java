package com.imooc.o2o.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-04-20 15:04
 */
public class JedisPoolWriper {
    // 连接池对象
    private JedisPool jedisPool;

    public JedisPoolWriper(final JedisPoolConfig poolConfig,final String host,final int port) {
        jedisPool = new JedisPool(poolConfig,host,port);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}


