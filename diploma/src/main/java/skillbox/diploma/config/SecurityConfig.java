package skillbox.diploma.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> {
                    authorize
                            .antMatchers(HttpMethod.GET, "/api/post/moderation").authenticated()
                            .antMatchers(HttpMethod.GET, "/api/post/my").authenticated()
                            .antMatchers(HttpMethod.GET, "/api/auth/logout").authenticated()
                            .antMatchers(HttpMethod.GET, "/api/statistics/my").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/post").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/image").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/comment").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/moderation").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/profile/my").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/post/like").authenticated()
                            .antMatchers(HttpMethod.POST, "/api/post/dislike").authenticated()
                            .antMatchers(HttpMethod.PUT, "/api/settings").authenticated()
                            .mvcMatchers(HttpMethod.PUT, "/api/post/{id}").authenticated();
                })
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic();
    }
}
