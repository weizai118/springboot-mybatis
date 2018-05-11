package com.gf.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: DruidConfig</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-05-07 11:46
 */
@Configuration
public class DruidConfig {


    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * //配置Druid的监控
     * //1.配置一个管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean( new StatViewServlet() , "/druid/*" );
        Map<String,String> initParams = new HashMap<>();
        initParams.put( "loginUsername" , "admin" );
        initParams.put( "loginPassword" , "123456" );
        //默认允许所有
        initParams.put( "allow" , "" );
        //initParams.put( "deny"  , "10.0.0.24");

        bean.setInitParameters( initParams );

        return bean;
    }

    /**
     * 配置一个web监控filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter( new WebStatFilter() );

        Map<String , String> initParams = new HashMap<>();
        initParams.put( "exclusions" , "*.js,*.css,/druid/*" );

        bean.setInitParameters( initParams );
        bean.setUrlPatterns( Arrays.asList( "/*" ) );

        return bean;
    }




}
