package kz.iitu.itse1903.birlikbai.config.app;

import io.swagger.models.HttpMethod;
import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.security.AuthenticationEntryPoint;
import kz.iitu.itse1903.birlikbai.security.CustomAuthenticationFailureHandler;
import kz.iitu.itse1903.birlikbai.service.AdminService;
import kz.iitu.itse1903.birlikbai.service.DriverService;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DriverService driverService;

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
        for (int i = 0; i < adminService.findAll().size(); i++) {
            String adminLogin = adminService.findAll().get(i).getLogin();
            String adminPassword = adminService.findAll().get(i).getPassword();

            auth.jdbcAuthentication()
                    .dataSource(dataSourceSecurity())
                    .withUser(adminLogin).password(passwordEncoder().encode(adminPassword)).roles("ADMIN");
        }

        for (int i = 0; i < driverService.findAll().size(); i++) {
            String driverId = Integer.toString(driverService.findAll().get(i).getDriverId());
            String driverPassword = driverService.findAll().get(i).getPassword();

            auth.jdbcAuthentication()
                    .dataSource(dataSourceSecurity())
                    .withUser(driverId).password(passwordEncoder().encode(driverPassword)).roles("DRIVER");
        }

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/user/**", "/loginPage/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/driver/driverSchedule").access("hasRole('DRIVER')")



                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint)

                .and().formLogin()

                .failureHandler(authenticationFailureHandler())

                .and()

                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logoutPage/"))

                .logoutSuccessUrl("/loginPage/")

                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);


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