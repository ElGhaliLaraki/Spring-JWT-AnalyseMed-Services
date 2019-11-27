package org.glsid.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/clients/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/analyses/**").permitAll();
		http.authorizeRequests().antMatchers("/clients/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/analyses/**").hasAuthority("USER");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterBefore(new JWTAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	}
       /* @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN","USER");
            auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER");

        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            super.configure(http);
        }
*/

}
