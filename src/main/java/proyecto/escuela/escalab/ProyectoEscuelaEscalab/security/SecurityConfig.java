package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.filter.CustomAuthenticationFilter;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.filter.CustomAuthorizationFilter;


@Configuration
@EnableWebSecurity
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
        http.authorizeRequests().antMatchers("/login/**", "/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/alumno/all**", "/alumno/{id}**", "/alumno/dniAndNombre**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/alumno/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/apoderado/all**", "/apoderado/{id}**", "/apoderado/dniAndNombre**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/apoderado/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/asignatura/all**", "/asignatura/{id}**", "/asignatura/nombreAndJornada**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/asignatura/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/contenido/all**", "/contenido/{id}**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/contenido/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/curso/all**", "/curso/{id}**", "/curso/nombreAndJornada**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/curso/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficha_medica/all**", "/ficha_medica/{id}**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/ficha_medica/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/profesor/all**", "/profesor/{id}**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/profesor/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/registro_academico/all**", "/registro_academico/{id}**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/registro_academico/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/toma_asignatura/all**", "/toma_asignatura/{id}**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers("/toma_asignatura/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/usuarios**").hasAnyAuthority("ROLE_ADMIN");
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
