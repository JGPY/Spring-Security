package vip.iotworld.web.config.WebConfig;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import vip.iotworld.web.filter.TimeFilter;
import vip.iotworld.web.interceptor.Timeinterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private Timeinterceptor timeinterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeinterceptor);
	}
	
	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean filterRegistrationBean = new  FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		filterRegistrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<String>();
		urls.add("/*");
		filterRegistrationBean.setUrlPatterns(urls);
		
		return filterRegistrationBean;
	}
}
