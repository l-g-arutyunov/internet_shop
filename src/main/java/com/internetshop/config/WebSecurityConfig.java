package com.internetshop.config;

import com.internetshop.service.security.UserDetailsServiceImpl;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Data
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().permitAll()
                    .and()
                .formLogin().permitAll()
                    .and()
                .logout()
                .clearAuthentication(true)
                .logoutUrl("/login")
                .deleteCookies("JSESSIONID")
                .permitAll()
                    .and()
                //.cors().disable()   // TODO: 18.08.2021
                //.csrf().disable()
                                    ;  // TODO: 18.08.2021

//        http.addFilterAfter(new CustomFilter(),
//                BasicAuthenticationFilter.class); // TODO: 18.08.2021
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder())
//                .usersByUsernameQuery("select login, password, true from users where login = ?")
//                .authoritiesByUsernameQuery("select 'leo' as login, 'admin' as role from users where login = ?");
        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());

    }
}
