package com.cyrill.springboot.config.session;


import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


//session托管到缓存中
@Configuration
//设置Session失效时间，使用Redis Session之后，原boot的server.sesion.timeout属性不在生效
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
}
