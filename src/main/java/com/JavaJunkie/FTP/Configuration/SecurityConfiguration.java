//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/uploadFile").permitAll()  // Allow access to this endpoint without authentication
//                .anyRequest().authenticated()           // Require authentication for other endpoints
//                .and()
//                .httpBasic()   // Use HTTP Basic Authentication (if needed)
//                .csrf().disable();  // Disable CSRF for testing
//    }
//}
