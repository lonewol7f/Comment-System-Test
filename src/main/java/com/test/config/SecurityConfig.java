package com.test.config;

/**
 * Created by Kalana on 18/07/2021
 */

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//     @Autowired
//     private DataSource dataSource;
//
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//     }
//
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.jdbcAuthentication().dataSource(dataSource)
//                 .usersByUsernameQuery("SELECT username,password,enabled " +
//                         "FROM users " +
//                         "WHERE username = ?")
//                 .authoritiesByUsernameQuery("SELECT username, authority " +
//                         "FROM authorities , users  " +
//                         "WHERE users.username = ? AND users.id = authorities.id")
//                 .passwordEncoder(passwordEncoder());
//     }
// }
