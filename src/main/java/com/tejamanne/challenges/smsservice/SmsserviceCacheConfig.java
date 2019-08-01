package com.tejamanne.challenges.smsservice;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class SmsserviceCacheConfig extends CachingConfigurerSupport {
	
	@Bean
	public KeyGenerator smsinboundsKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				/*if (params[2] != null && params[2].toString().equalsIgnoreCase("STOP")) {
					for (int i = 0; i < params.length - 1; i++) {
						sb.append(params[i].toString());
					}
				}*/
				for (int i = 0; i < params.length; i++) {
					sb.append(params[i].toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean
	public KeyGenerator smsoutboundsKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				for (int i = params.length - 1; i >= 0; i--) {
					sb.append(params[i].toString());
				}
				return sb.toString();
			}
		};
	}
}
