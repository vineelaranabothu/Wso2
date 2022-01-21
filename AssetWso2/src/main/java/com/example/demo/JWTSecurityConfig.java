package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


@Configuration
@Order (1)
@EnableResourceServer
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {



@Override
protected void configure(HttpSecurity http) throws Exception 
{
	
	http.authorizeRequests(authz -> authz.antMatchers(HttpMethod.GET,"/api/**").hasAnyRole("MANAGER","EMPLOYEE")
			.antMatchers(HttpMethod.POST, "/api/**").hasRole("EMPLOYEE")
			.antMatchers("/").permitAll()
			.anyRequest().authenticated())
	        .oauth2Login().and()
	        .logout().logoutSuccessHandler(oidcLogoutSuccessHandler())
	        .and().oauth2ResourceServer(oauth2 -> oauth2.jwt());

	
	
}
   


//Inject the ClientRegistrationRepository which stores client registration information
@Autowired
private ClientRegistrationRepository clientRegistrationRepository;

/**
 * Create a OidcClientInitiatedLogoutSuccessHandler
 *
 * @return OidcClientInitiatedLogoutSuccessHandler
 */
private LogoutSuccessHandler oidcLogoutSuccessHandler() {

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
            new OidcClientInitiatedLogoutSuccessHandler(
                    this.clientRegistrationRepository);

    oidcLogoutSuccessHandler.setPostLogoutRedirectUri(
            "https://localhost:8443"); //Need to give the post-rediret-uri here

    return oidcLogoutSuccessHandler;
}


@Bean
public JwtDecoder customJwtDecoder() {
return NimbusJwtDecoder.withJwkSetUri("http://localhost:9763/oauth2/jwks").build();
}

@Bean
GrantedAuthorityDefaults grantedAuthorityDefaults() {
return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
}

}






