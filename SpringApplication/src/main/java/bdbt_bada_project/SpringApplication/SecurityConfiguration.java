package bdbt_bada_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    /**
     * Defines a password encoder. In this case, no encoding is applied (for development only).
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Configures in-memory user details for testing purposes.
     * Users: "user" with role USER, "admin" with role ADMIN.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * Configures the security filter chain, defining authorization rules, login, and logout behavior.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Authorization rules
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/index").permitAll() // Allow access to root and index pages
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                // Login configuration
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page URL
                        .permitAll() // Allow everyone to access the login page
                )
                // Logout configuration
                .logout(logout -> logout
                        .logoutSuccessUrl("/index") // Redirect to index page after logout
                        .permitAll() // Allow everyone to log out
                );
        return http.build();
    }
}
