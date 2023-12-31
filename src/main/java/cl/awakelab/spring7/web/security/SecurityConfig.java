package cl.awakelab.spring7.web.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder){
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .requestMatchers("/**").hasRole("ADMIN") // Requiere el rol "ADMIN" para acceder a rutas que comiencen con "/admin"
                .requestMatchers("/**").hasRole("USER") // Requiere el rol "USER" para acceder a rutas que comiencen con "/user"
                .and()
                .formLogin(); // Habilitar el formulario de inicio de sesión
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Puedes usar diferentes algoritmos de codificación según tus necesidades
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
