package com.vtomu.annotation;

import com.vtomu.enums.RedisType;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RedisCache {
	/**
	 * redis的Key：类似于com.vtomu.user
	 * @return
	 */
	String name();
	/**
	 * 方法的参数：类似于1/2/3这些参数
	 * @return
	 */
	String params();
	/**
	 * 存在redis中多长时间
	 * @return
	 */
	long expiresTime() default 0;
	/**
	 * 映射的类
	 * @return
	 */
	Class<?> clazz() default Object.class;
	/**
	 * 存的数据类型
	 * @return
	 */
	RedisType redisType() default RedisType.String;
	/**
	 * 存储的类型
	 */
	TimeUnit expiresType() default TimeUnit.MINUTES;

}
