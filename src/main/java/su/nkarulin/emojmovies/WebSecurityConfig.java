package su.nkarulin.emojmovies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import su.nkarulin.emojmovies.domain.user.UserRole;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/movies/management/**").authenticated()
                .antMatchers("/movies/delete/**").hasRole(UserRole.ADMIN.name())
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/movies/")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable()
            // for h2 console to be available
            .headers().frameOptions().sameOrigin();
    }
}
