package top.oranges.config;

/**
 * @author: orange
 * @projectName: 4-auth-logout
 * @description:
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import top.oranges.handler.JsonLogoutSuccessHandler;
import top.oranges.handler.MyLogoutHandler;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // 配置所有的Http请求必须认证
        http.authorizeHttpRequests()
                .requestMatchers("/login.html", "/demo.html")
                .permitAll()
                .anyRequest()
                .authenticated();

        // 开启表单登录
        http.formLogin();

        //自定义注销登录请求处理路径
//        http.logout().logoutUrl("custom/logout");

//        // 注销登录
//        http.logout()
//                // 自定义注销登录URL（和logoutUrl 配置只会生效一个）
//                .logoutRequestMatcher(new OrRequestMatcher(
//                        new AntPathRequestMatcher("/aaa", "GET"),
//                        new AntPathRequestMatcher("/bbb", "GET")
//                ));
        // 注销登录
        http.logout()
                .clearAuthentication(true)
                .deleteCookies("xxx", "yyy")
                .invalidateHttpSession(true)
                // 自定义注销登录请求处理路径
                .logoutUrl("/custom/logout")
                //注销成功后跳转的页面
                .logoutSuccessUrl("/demo.html")
                .addLogoutHandler(new MyLogoutHandler())
                .logoutSuccessHandler(new JsonLogoutSuccessHandler());;
        // 开启Basic认证
        http.httpBasic();

        // 关闭 CSRF
        http.csrf().disable();
        return http.build();
    }

}