package config;

import Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan({"controller"})
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

//
//    @Autowired
//    Repository.userRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(
                        "/reg/**",
                        "/index/**").permitAll().anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/LoginForm")
                .usernameParameter("Email")
                .defaultSuccessUrl("/results.html", true)
                .failureUrl("/LoginForm.html?error=true")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                //make
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();


//        http.csrf().disable();
    }
//                .loginProcessingUrl("/perform_login")
}