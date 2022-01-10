package com.example.CassandraAsset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;




@Configuration
@Order (1)
@EnableResourceServer
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {



@Override
protected void configure(HttpSecurity http) throws Exception 
{
	http.authorizeRequests(authz -> authz.antMatchers(HttpMethod.GET, "/api/**").hasAuthority("SCOPE_read_access")
											.antMatchers(HttpMethod.POST, "/api/**").hasAuthority("SCOPE_write")
											.antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority("SCOPE_write")
											.antMatchers(HttpMethod.PUT, "/api/**").hasAuthority("SCOPE_write")
												.anyRequest().authenticated())
												.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt
								      					.decoder(customJwtDecoder())
														));
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
