package com.vtomu.jedis.util;


import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;


/**
 * redis缓存工具
 * @author imeto
 *
 */
@SuppressWarnings("unchecked")
@Component
public class RedisCacheUtil {

	
	public static final String USER_INFO_CACHE_PREFIX="USER_INFO";//用户信息缓存前缀
	
	public static final String USER_ARTICLE_INFO_CACHE_PREFIX="USER_ARTICLE_INFO";//文章的信息缓存前
	//用户消息缓存前缀
	public static final String USER_MESSAGE_INFO_CACHE_PREFIX="USER_MESSAGE";
	//kafka消息
	public static final String KAFKA_MESSAGE_CACHE_PREFIX="KAFKA_MESSAGE";
	//
	/*public static final String 
	public static final String*/ 
	  
	@Autowired
	  private RedisTemplate redisTemplate;
	
	 public void remove(final String... keys) {
	        for (String key : keys) {
	            remove(key);
	        }
	    }

	    /**
	     * 批量删除key
	     *
	     * @param pattern
	     */
	    public void removePattern(final String pattern) {
	        Set<Serializable> keys = redisTemplate.keys(pattern);
	        if (keys.size() > 0)
	            redisTemplate.delete(keys);
	    }

	    /**
	     * 删除对应的value
	     *
	     * @param key
	     */
	    public void remove(final String key) {
	        if (exists(key)) {
	            redisTemplate.delete(key);
	        }
	    }

	    /**
	     * 判断缓存中是否有对应的value
	     *
	     * @param key
	     * @return
	     */
	    public boolean exists(final String key) {
	        return redisTemplate.hasKey(key);
	    }

	    /**
	     * 读取缓存
	     *
	     * @param key
	     * @return
	     */
	    public Object get(final String key) {
	        Object result = null;
	        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	        result = operations.get(key);
	        return result;
	    }

	    /**
	     * 写入缓存
	     *
	     * @param key
	     * @param value
	     * @return
	     */
	    public boolean set(final String key, Object value) {
	        boolean result = false;
	        try {
	            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	            operations.set(key, value);
	            result = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    /**
	     * 写入缓存
	     *
	     * @param key
	     * @param value
	     * @return
	     */
	    public boolean set(final String key, Object value, Long expireTime) {
	        boolean result = false;
	        try {
	            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	            operations.set(key, value);
	            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	            result = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }


	
	
}
