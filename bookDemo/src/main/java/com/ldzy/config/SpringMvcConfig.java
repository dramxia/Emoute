package com.ldzy.config;

import com.ldzy.interceptor.LoninInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//等同于<context:component-scan base-package="com.itheima.controller"/>
@ComponentScan("com.ldzy.controller")
//等同于<mvc:annotation-driven/>，还不完全相同
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer  {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoninInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }

    /*
     *开启对静态资源的访问
     * 类似在Spring MVC的配置文件中设置<mvc:default-servlet-handler/>元素
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**");
//    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/",".jsp");
    }
}

