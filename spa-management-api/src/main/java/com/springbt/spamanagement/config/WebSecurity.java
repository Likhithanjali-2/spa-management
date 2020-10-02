package com.springbt.spamanagement.config;

import com.springbt.spamanagement.security.JWTAuthenticationFilter;
import com.springbt.spamanagement.security.JWTAuthorizationFilter;
import com.springbt.spamanagement.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/** @author Givantha Kalansuriya @Project spring-boot-rest-api-auth-jwt-tutorial */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    public static final String SIGN_UP_URL = "/api/v1/users";

    @Autowired private UserDetailServiceImpl userDetailService;

    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(
            UserDetailServiceImpl userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailService = userDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests() // Add a new custom security filter
                .antMatchers(HttpMethod.POST, SIGN_UP_URL)
                .permitAll() // Only Allow Permission for create user endpoint
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(this.getJWTAuthenticationFilter()) // Add JWT Authentication Filter
                .addFilter(
                        new JWTAuthorizationFilter(authenticationManager())) // Add JWT Authorization Filter
                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS); // this disables session creation on Spring Security
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        //the below three lines will add the relevant CORS response headers
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
            }
        };
    }
    public JWTAuthenticationFilter getJWTAuthenticationFilter() throws Exception {
        final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/api/v1/auth/login"); // override the default spring login url
        return filter;
    }

}
