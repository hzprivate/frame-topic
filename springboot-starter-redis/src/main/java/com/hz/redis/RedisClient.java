package com.hz.redis;

import com.hz.config.RedisConf;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

/**
 * redis 调用工具类
 * @author hz
 * @create 2021-01-13
 */
public class RedisClient {
    public static RedisConf redisconf;
    private static JedisPool jedisPool;

    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(5000);
            config.setMaxIdle(256);
            config.setMaxWaitMillis(5000L);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            config.setTestWhileIdle(true);
            config.setMinEvictableIdleTimeMillis(60000L);
            config.setTimeBetweenEvictionRunsMillis(3000L);
            config.setNumTestsPerEvictionRun(-1);
            jedisPool = new JedisPool(config, redisconf.getIp(), redisconf.getPort(), 60000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (jedisPool == null) {
            initialPool();
        }
    }

    /**
     * 同步获取Jedis实例
     *
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
                jedis.select(redisconf.getNum());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//finally{
        //    returnResource(jedis);
        //}
        return jedis;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedis.close();
        }
    }

//    public static void RedisClient(RedisConf conf){
//        redisconf = conf;
//        if(jedisPool == null){
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(5000);
//            config.setMaxIdle(256);
//            config.setMaxWaitMillis(5000L);
//            config.setTestOnBorrow(true);
//            config.setTestOnReturn(true);
//            config.setTestWhileIdle(true);
//            config.setMinEvictableIdleTimeMillis(60000L);
//            config.setTimeBetweenEvictionRunsMillis(3000L);
//            config.setNumTestsPerEvictionRun(-1);
//            jedisPool = new JedisPool(config, redisconf.getIp(), redisconf.getPort(), 60000);
//        }
//    }

//    public static void close(Jedis jedis) {
//        try {
//            //jedisPool.returnResource(jedis);
//            if(jedis != null)
//                jedis.close();
//        }
//        catch (Exception e) {
//            if (jedis.isConnected()) {
//                jedis.quit();
//                jedis.disconnect();
//            }
//        }
//    }

    public static String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    public static byte[] get(byte[] key) {
        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return value;
    }

    public static void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static void set(String key, String value, int time) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
            jedis.expire(key, time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static void hset(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static void hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static String hget(String key, String field) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return value;
    }

    public static byte[] hget(byte[] key, byte[] field) {
        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return value;
    }

    public static void hdel(byte[] key, byte[] field) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hdel(key, new byte[][]{field});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static long lpush(String key, String value) {
        Jedis jedis = null;
        long len = 0L;
        try {
            jedis = getJedis();
            len = jedis.lpush(key, new String[]{value});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return len;
    }

    public static void lrem(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            jedis.lrem(key, 1, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static long rpush(byte[] key, byte[] value) {
        long len = 0L;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            len = jedis.rpush(key, new byte[][]{value});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return len;
    }

    public static long rpush(String key, String value) {
        long len = 0L;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            len = jedis.rpush(key.getBytes(StandardCharsets.UTF_8), value.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return len;
    }

    public static void rpoplpush(byte[] key, byte[] destination) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.rpoplpush(key, destination);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static List<byte[]> lpopList(byte[] key) {
        List list = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            list = jedis.lrange(key, 0L, -1L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return list;
    }

    public static String rpop(String key) {
        String bytes = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            bytes = jedis.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return bytes;
    }

    public static List<byte[]> lrange(byte[] key, int from, int to) {
        List result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            //jedis.select(redisconf.getNum());
            result = jedis.lrange(key, from, to);
        } catch (Exception e) {
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    public static List<String> lrange(String key, int from, int to) {
        List result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.lrange(key, from, to);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    public static void del(String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static long llen(byte[] key) {
        long len = 0L;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            len = jedis.llen(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return len;
    }

    public static long llen(String key) {
        long len = 0L;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            len = jedis.llen(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return len;
    }

    public static Set<String> keys(String key) {
        Set<String> list = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            list = jedis.keys(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return list;
    }

    public static boolean sismember(String key, String val) {
        boolean ok = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            ok = jedis.sismember(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return ok;
    }

    public static long sadd(String key, String val) {
        long ok = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            ok = jedis.sadd(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return ok;
    }

    public static long srem(String key, String val) {
        long ok = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            ok = jedis.srem(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return ok;
    }

    public static String lpop(String key) {
        String str = "";
        Jedis jedis = null;
        try {
            jedis = getJedis();
            str = jedis.lpop(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return str;
    }

    public static Set<String> smembers(String key) {
        Set<String> list = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            list = jedis.smembers(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return list;
    }
}