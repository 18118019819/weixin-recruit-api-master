package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    /**
     * 配置监控服务器(后台监控)
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","admin");//loginUsername和loginPassword本身关键词不能改
        initParameters.put("loginPassword","123456");
        initParameters.put("allow","");//允许谁能访问  "":都能访问 "localhost":本机  一般设置为具体的用户
//        initParameters.put("username","192.168.11.123");   //禁止谁访问

        //设置后台能登陆的人
        bean.setInitParameters(initParameters);
        return  bean;
    }
    /**
     * 配置服务过滤器
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());

        Map<Object, Object> initParameters = new HashMap<>();
        //过滤这些请求不进行统计
        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
