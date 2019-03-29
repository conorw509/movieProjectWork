package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan({"controller"})
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
//                .loginProcessingUrl("/perform_login")
                .loginPage("/loginForm")
                .usernameParameter("email")
                .defaultSuccessUrl("/results.html", true)
                .failureUrl("/loginForm.html?error=true");

        http .csrf().disable();
    }

}