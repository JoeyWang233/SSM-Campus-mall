package com.imooc.o2o.cache;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.SafeEncoder;

public class JedisUtil {
    /**
     * 缓存生存时间
     */
    private final int expire = 60000;
    public Keys KEYS;
    public Strings STRINGS;

    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPoolWriper jedisPoolWriper) {
        this.jedisPool = jedisPoolWriper.getJedisPool();
    }

    /**
     * 从jedis连接池中获取获取jedis对象
     *
     * @return
     */
    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    // *******************************************Keys*******************************************//
    public class Keys {

        /**
         * 清空所有key
         */
        public String flushAll() {
            Jedis jedis = JedisUtil.this.getJedis();
            String stata = jedis.flushAll();
            jedis.close();
            return stata;
        }

        /**
         * 删除keys对应的记录,可以是多个key
         *
         * @param
         * @return 删除的记录数
         */
        public long del(String... keys) {
            Jedis jedis = JedisUtil.this.getJedis();
            long count = jedis.del(keys);
            jedis.close();
            return count;
        }

        /**
         * 判断key是否存在
         *
         * @param
         * @return boolean
         */
        public boolean exists(String key) {
            // ShardedJedis sjedis = getShardedJedis();
            Jedis sjedis = JedisUtil.this.getJedis();
            boolean exis = sjedis.exists(key);
            sjedis.close();
            return exis;
        }

        /**
         * 查找所有匹配给定的模式的键
         *
         * key的表达式,*表示多个，？表示一个
         */
        public Set<String> keys(String pattern) {
            Jedis jedis = JedisUtil.this.getJedis();
            Set<String> set = jedis.keys(pattern);
            jedis.close();
            return set;
        }
    }

    // *******************************************Strings*******************************************//
    public class Strings {
        /**
         * 根据key获取记录
         */
        public String get(String key) {
            // ShardedJedis sjedis = getShardedJedis();
            Jedis sjedis = JedisUtil.this.getJedis();
            String value = sjedis.get(key);
            sjedis.close();
            return value;
        }

        /**
         * 添加记录,如果记录已存在将覆盖原有的value
         */
        public String set(String key, String value) {
            return set(SafeEncoder.encode(key), SafeEncoder.encode(value));
        }

        /**
         * 添加记录,如果记录已存在将覆盖原有的value
         *
         *
         */
        public String set(byte[] key, byte[] value) {
            Jedis jedis = JedisUtil.this.getJedis();
            String status = jedis.set(key, value);
            jedis.close();
            return status;
        }
    }

    public class Lists{}
    public class Sets{}
    public class Hash{}
}