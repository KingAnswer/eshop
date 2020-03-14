package com.qingshixun.project.eshop.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 倩513
 *
 */
@Component
public class PropertiesListener implements ApplicationListener<ContextRefreshedEvent>{
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AlipayProperties.loadProperties();
	}
	
}
