package com.vtomu.handle;

import com.vtomu.annotation.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class RedisCacheHandle {
	
	private static final Logger logger=LoggerFactory.getLogger(RedisCacheHandle.class);
	
	@Autowired
	private RedisTemplate redisTemplate;



	/*@Around("execution(* com.vtomu.dao.*(..))")*/
	@Around("@annotation(com.vtomu.annotation.RedisCache)")
	public Object addRedisCache(ProceedingJoinPoint pjp) {
		//根据切入点找到具体的方法
		MethodSignature ms=(MethodSignature) pjp.getSignature();
		Method method=ms.getMethod();

		Long time=method.getAnnotation(RedisCache.class).expiresTime();
		TimeUnit timeUnit=method.getAnnotation(RedisCache.class).expiresType();
		//获取Key
		String redisKey = getCacheKey(pjp);
		Object objectFromRedis = redisTemplate.opsForValue().get(redisKey);
		if(objectFromRedis != null) {
			logger.info("我得到数据是从redis查到的返回了嘿嘿");
			return objectFromRedis;
		}
		Object object = null;
		try {
			object = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		redisTemplate.opsForValue().set(redisKey, object, time, timeUnit);
		return object;
	}
	
	 private String getCacheKey(ProceedingJoinPoint joinPoint) {
	          MethodSignature ms=(MethodSignature) joinPoint.getSignature();
	         Method method=ms.getMethod();
	          String ActionName = method.getAnnotation(RedisCache.class).name();
	          String fieldList = method.getAnnotation(RedisCache.class).params();
	          for (String field:fieldList.split(","))
	               ActionName +="."+field;
	     
	         //先获取目标方法参数
	          String id = null;
	          Object[] args = joinPoint.getArgs();
	         if (args != null && args.length > 0) {
	             id = String.valueOf(args[0]);
	         }
	        
	         ActionName += "="+id;
	        String redisKey = ms+"."+ActionName;
	         return redisKey;
	     }
	     






	  /*   public void setRedisTemplate(  
	             RedisTemplate<Serializable, Object> redisTemplate) {  
	         this.redisTemplate = redisTemplate;  
	     }
	
	     private LogService logService;
	 	public LogService getLogService() {
	 		return logService;
	 	}

	 	//自动注入日志记录service
	 	@Autowired
	 	public void setLogService(LogService logService) {
	 		this.logService = logService;
	 	}
	 	//环绕通知方法
	 	@Around("execution(* unkeltao.service.*.*(..))")
	 	public Object doWriteLog(ProceedingJoinPoint pjp) throws Throwable {
	 		System.err.println("拦截方法,进入日志记录");
	 		// 拦截的实体类
	 		Object target = pjp.getTarget();
	 		// 拦截的方法名称
	 		String methodName = pjp.getSignature().getName();
	 		// 拦截的方法参数
	 		Object[] args = pjp.getArgs();
	 		
	 		// 拦截的放参数类型
	 		Class[] parameterTypes = ((MethodSignature) pjp.getSignature())
	 				.getMethod().getParameterTypes();

	 		Object object = null;
	 		
	 		//需要转换成Json的HashMap
	 		Map<String, Object> maps = new HashMap<String, Object>();
	 		Map<String, Object> parammaps = new HashMap<String, Object>();
	 		// 获得被拦截的方法
	 		Method method = target.getClass().getMethod(methodName, parameterTypes);
	 		if (null != method) {
	 			// 判断是否包含自定义的注解
	 			if (method.isAnnotationPresent(MyAnnotation.class)) {
	 				// 获取自定义注解实体
	 				MyAnnotation myAnnotation = method
	 						.getAnnotation(MyAnnotation.class);
	 				//日志类实体类
	 				OptionLog log = new OptionLog();
	 				
	 				log.setUserid(myAnnotation.userid());
	 				log.setModelname(myAnnotation.modelName());
	 				log.setOp(myAnnotation.option());
	 				maps.put("方法名", method.getName());
	 				parammaps.put("方法名", method.getName());
	                 //循环获得所有参数对象
	 				for(int i=0; i<args.length; i++){
	 					if (null != args[i]) {
	 						parammaps.put("args["+i+"]", args[i]);
	 					}
	 					else {
	 						parammaps.put("args["+i+"]", "空参数");
	 					}
	 				}
	 				maps.put("参数", parammaps);
	 				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	 				maps.put("操作时间", sdf.format(new Date()));
	 				// 获取服务运行结果
	 				try {
	 					object = pjp.proceed();// 执行该方法
	 					maps.put("状态", "成功");
	 					log.setStatus(1);
	 				} catch (Exception e) {
	 					System.err.println(e.getMessage());
	 					maps.put("状态", "失败");
	 					log.setStatus(0);
	 					log.setComments(e.getMessage());
	 				}
	 				//将参数转化为Json字符串
	 				log.setJs(new JSONObject(maps).toJSONString());
	 				log.setOptime(new Date());
	 				System.err.println(new JSONObject(maps).toJSONString());  
	 				
	 				//记录相关日志
	 				if (null != logService) {
	 					try {
	 						if(1 == logService.Save(log)){
	 							System.err.println("日志记录成功");
	 						}
	 						else{
	 							System.err.println("日志记录失败");
	 						}
	 						
	 					} catch (Exception e) {
	 						e.printStackTrace();
	 					}
	 				}
	 				else{
	 					System.err.println("自动注入失败，日志未记录");
	 				}

	 			} else { // 没有包含该注解则不进行其他处理
	 				object = pjp.proceed();// 执行该方法
	 			}

	 		} else { // 不需要拦截，直接运行
	 			object = pjp.proceed(); // 执行该方法
	 		}
	 		return object;*/
	     
	     
	     

}
