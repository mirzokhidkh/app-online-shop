package uz.mk.apponlineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.mk.apponlineshop.model.Authority;
import uz.mk.apponlineshop.model.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    1-vazifa
//
//    https://pcmarket.uz saytining security qismini yozish. Bunda inMemory da 3 ta user qo'shiladi.
//    SUPER_ADMIN, MODERATOR va OPERATOR rollari bo’lsin.
//    SUPER_ADMIN har qanday ishni qila oladi;
//    MODERATOR mahsulot qo’sha oladi va tahrirlay oladi ,ammo o’chira olmaydi;
//    OPERATOR buyurtmalar bilan ishlaydi, mahsulotni o'chira olmaydi va tahrirlay olmaydi.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super_admin").password(passwordEncoder().encode("123")).roles(Role.SUPER_ADMIN)
                .authorities(Authority.READ_ALL, Authority.READ_ONE, Authority.ADD, Authority.EDIT, Authority.DELETE)
                .and()
                .withUser("moderator").password(passwordEncoder().encode("123")).roles(Role.MODERATOR)
                .authorities(Authority.READ_ALL, Authority.READ_ONE, Authority.ADD, Authority.EDIT)
                .and()
                .withUser("operator").password(passwordEncoder().encode("123")).roles(Role.OPERATOR)
                .authorities(Authority.READ_ALL, Authority.READ_ONE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/product").hasAuthority(Authority.READ_ALL)
//                .antMatchers(HttpMethod.GET, "/api/product/*").hasAuthority(Authority.READ_ONE)
//                .antMatchers(HttpMethod.POST, "/api/product").hasAuthority(Authority.ADD)
//                .antMatchers(HttpMethod.PUT, "/api/product/*").hasAuthority(Authority.EDIT)
//                .antMatchers(HttpMethod.DELETE, "/api/product/*").hasAuthority(Authority.DELETE)
//                .antMatchers("/api/product/**").hasAnyAuthority(Authority.READ_ALL, Authority.ADD, Authority.EDIT, Authority.DELETE, Authority.READ_ONE)
                .antMatchers(HttpMethod.GET, "/api/*").hasAuthority(Authority.READ_ALL)
                .antMatchers(HttpMethod.GET, "/api/**").hasAuthority(Authority.READ_ONE)
                .antMatchers(HttpMethod.POST, "/api/*").hasAuthority(Authority.ADD)
                .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority(Authority.EDIT)
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Authority.DELETE)
                .antMatchers("/api/**").hasAnyAuthority(Authority.READ_ALL, Authority.ADD, Authority.EDIT, Authority.DELETE, Authority.READ_ONE)
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
