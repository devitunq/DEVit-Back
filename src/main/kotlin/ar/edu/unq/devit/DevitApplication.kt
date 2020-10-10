package ar.edu.unq.devit

import ar.edu.unq.devit.security.JWTAuthorizationFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@SpringBootApplication(exclude = [MongoAutoConfiguration::class])
class DevitApplication

fun main(args: Array<String>) {
	runApplication<DevitApplication>(*args)
}

@EnableWebSecurity
@Configuration
internal class WebSecurityConfig : WebSecurityConfigurerAdapter() {
	@Throws(Exception::class)
	override fun configure(http: HttpSecurity) {
		http.csrf().disable()
				.addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
				.authorizeRequests()
				.antMatchers( "/api/user", "/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**").permitAll()
				.anyRequest().authenticated()
	}
}