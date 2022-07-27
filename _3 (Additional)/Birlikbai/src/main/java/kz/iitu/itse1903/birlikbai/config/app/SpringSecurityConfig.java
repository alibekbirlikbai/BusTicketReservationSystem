package kz.iitu.itse1903.birlikbai.config.app;

import kz.iitu.itse1903.birlikbai.security.AuthenticationEntryPoint;
import kz.iitu.itse1903.birlikbai.security.CustomAuthenticationFailureHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public DataSource dataSourceSecurity() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:db/security/schema.sql", "classpath:db/security/data.sql").build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSourceSecurity())
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("driver").password(passwordEncoder().encode("driver")).roles("DRIVER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/user/index")
                .antMatchers("/user/buyTicket")
                .antMatchers("/user/payment")
                .antMatchers("/user/showTicket")
                .antMatchers("/loginPage");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

                .antMatchers("/admin/adminHome").hasAnyRole("ADMIN")
                .antMatchers("/admin/adminBus").hasAnyRole("ADMIN")
                .antMatchers("/admin/adminDriver").hasAnyRole("ADMIN")
                .antMatchers("/admin/adminSchedule").hasAnyRole("ADMIN")
                .antMatchers("/admin/adminBooking").hasAnyRole("ADMIN")
                //*************************
                .antMatchers("/driver/driverSchedule").hasAnyRole("DRIVER")
                //*************************
//                .antMatchers("/user/index").permitAll()
//                .antMatchers("/user/buyTicket").permitAll()
//                .antMatchers("/user/payment").permitAll()
//                .antMatchers("/user/showTicket").permitAll()
//                .antMatchers("/loginPage").permitAll()

                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint)

                .and().formLogin()
                .failureHandler(authenticationFailureHandler())
                .and().rememberMe()

                .and().cors().
                and().headers().xssProtection()
                .and()
                .contentSecurityPolicy("script-src 'self'");

                    http.sessionManagement()
                            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

    }


    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
