package com.example.pr2.account.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.sql.DataSource

/*

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    @Autowired
    private val dataSource: DataSource
)  {



    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers(
                        "/",
                    )
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .formLogin { form ->
                form
                    .loginPage("/login")
                    .permitAll()

            }
            .logout { logout -> logout.permitAll() }
        return http.build()
    }

   */
/* @Bean
    fun userDetailsService(): UserDetailsService {
        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(user)
    }*//*


    @Bean
    protected fun configure(auth: AuthenticationManagerBuilder): Unit {
        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(BCryptPasswordEncoder())
            .usersByUsernameQuery("select username, password, active from model_user where username =?")
            .authoritiesByUsernameQuery("select u.username, ur.roles from model_user u inner join user_role ur on u.id_user = ur.user_id where u.username=?")
    }

}
*/


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    private val dataSource: DataSource? = null
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(BCryptPasswordEncoder())
            .usersByUsernameQuery("select login, password /*, active*/ from u where login =?")
            .authoritiesByUsernameQuery("select u.login, roles from u as u inner join user_role as ur on u.id = ur.user_id where u.login=?")

    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/login","/registration").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and().csrf().disable().cors().disable();

    }
}