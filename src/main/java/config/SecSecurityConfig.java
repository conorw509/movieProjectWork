package config;

import Repository.userRepository;
import model.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.activation.DataContentHandler;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    userRepository userRepository;


    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email,password, enabled from users where email=?");
//                .authoritiesByUsernameQuery(
//                        "select username, role from user_roles where username=?");
    }

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(WebSecurity security) {
        security.ignoring().antMatchers("/css/**", "/images/**", "/js/**");
    }

//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select email,password, enabled from users where username=?");
////                .authoritiesByUsernameQuery(
////                        "select username, role from user_roles where username=?");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//         http.authorizeRequests().antMatchers("/reg", "/", "/LoginForm").permitAll();
//                .authorizeRequests()
//                .antMatchers("/reg", "/", "/LoginForm").permitAll()//.hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/j_spring_security_check")
//                .loginPage("/LoginForm")
//                .usernameParameter("Email")
//                .defaultSuccessUrl("/results.html", true)
//                .permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/results");

         http.csrf().disable();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        http.authorizeRequests().antMatchers("/reg", "/", "/LoginForm").permitAll();

        http
                .formLogin().loginPage("/LoginForm")
                .usernameParameter("Email").passwordParameter("password")
                .and()
                .logout();


    }
//                .loginProcessingUrl("/perform_login")


    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }


}

