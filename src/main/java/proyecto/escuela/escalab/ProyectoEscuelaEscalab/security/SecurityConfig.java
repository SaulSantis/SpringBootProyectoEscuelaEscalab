package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.filter.CustomAuthenticationFilter;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.filter.CustomAuthorizationFilter;

import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login/**");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**", "/token/refresh/**", "/swagger-ui.html/**").permitAll();
        http.authorizeRequests().antMatchers(DELETE, "/alumno/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/alumno/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/alumno/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/alumno/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/curso/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/curso/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/curso/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/curso/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/profesor/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/profesor/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/profesor/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/profesor/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/asignatura/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/asignatura/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/asignatura/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/asignatura/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/contenido/delete/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR");
        http.authorizeRequests().antMatchers(POST, "/contenido/save/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR");
        http.authorizeRequests().antMatchers(PUT, "/contenido/update/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR");
        http.authorizeRequests().antMatchers(GET, "/contenido/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/apoderado/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/apoderado/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/apoderado/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/apoderado/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/ficha_medica/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/ficha_medica/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/ficha_medica/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/ficha_medica/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(DELETE, "/usuarios/delete/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/usuarios/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/usuarios/update/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/usuarios/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_USER");

        http.authorizeRequests().antMatchers(POST, "/rol/save/**", "/rol/addToUser/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
