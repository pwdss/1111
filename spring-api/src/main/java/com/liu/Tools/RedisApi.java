package com.liu.Tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 独狼Kiss
 * @title: RedisApi
 * @projectName testdemo
 * @description: TODO
 * @date 2021/1/298:54
 */
public class RedisApi {
    public JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    //常用方法
    //1.存值
    public boolean set(String key,String  value){
        Jedis jedis = null;
        try {
            jedis=jedisPool.getResource();
            jedis.set(key,value);
            return  true;
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (jedis!=null){
                returnResource(jedisPool,jedis);
            }
        }
        return false;
    }
    //2设置有效期
    public Boolean set(String key,int seconds,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.setex(key,seconds,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){
                returnResource(jedisPool,jedis);
            }
        }
        return false;

    }
    //3判断某个值是否存在
    public Boolean exist(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.exists(key);

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (jedis!=null){
                returnResource(jedisPool,jedis);
            }
        }
        return false;
    }
    //4返回连接池的共有方法
    public static void returnResource(JedisPool jedisPool,Jedis jedis){
        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
    }
    //5取值
    public String get(String key){
        String value = null;
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){

                returnResource(jedisPool,jedis);
            }
        }
        return value;
    }
    //6查询有效期
    public long ttl(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.ttl(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){

                returnResource(jedisPool,jedis);
            }
        }
        return (long) -2;


    }
    //7删除key
    public void delete(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){

                returnResource(jedisPool,jedis);
            }
        }
    }
}
