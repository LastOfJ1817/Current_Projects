package com.websystique.springmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	PersistentTokenRepository tokenRepository;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter ();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("add-dogovor-*", "/show-dogovors-*").access("hasRole('ADMIN') or hasRole('DBA') or hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/show-contragents-*").access("hasRole('ADMIN') or hasRole('DBA') or hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/add-contragent-*").access("hasRole('ADMIN') or hasRole('DBA') or hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/show-debits-*").access("hasRole('ADMIN') or hasRole('DBA') or hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/registration").permitAll()
				.antMatchers("/personal", "/add-debit-*", "/add-debit", "/personal-*").access("hasRole('ADMIN') or hasRole('DBA') or hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/list").access("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('DBA')")
				.antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')")
				.antMatchers("/addphone-*", "/edit-phone-*").access("hasRole('ADMIN') or hasRole('DBA') or hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/show-phones", "/show-phone-*").access("hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/add-act-*", "/show-acts-*").access("hasRole('MANAGER') or hasRole('USER')")
				.antMatchers("/edit-user-*", "/edit-useritself-*")
				.access("hasRole('ADMIN') or hasRole('DBA') or hasRole('USER')").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
				.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
				.tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

}