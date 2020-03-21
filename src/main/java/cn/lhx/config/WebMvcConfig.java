package cn.lhx.config;

import cn.lhx.component.LoginInterceptor;
import cn.lhx.component.MyLocaleResolver;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author lee549
 * @date 2020/3/14 20:27
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginInterceptor())
                    .addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/login", "/favicon.ico");
        }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
