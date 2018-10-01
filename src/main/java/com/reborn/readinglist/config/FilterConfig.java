package com.reborn.readinglist.config;

import com.reborn.readinglist.Filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean loginFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
