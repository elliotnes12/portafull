package mx.xpd.cfdi.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.Assert;

public class XPDUsernamePasswordAuthenticationFilter extends
		AbstractAuthenticationProcessingFilter {
	
	public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
	public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";


	@Deprecated
	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";
	private String usernameParameter = "j_username";
	private String passwordParameter = "j_password";
	private boolean postOnly = false;

	public XPDUsernamePasswordAuthenticationFilter() {
		super("/j_spring_security_check");
		
	}

	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		if ((this.postOnly) && (!(request.getMethod().equals("POST")))) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}
		

		String username = obtainUsername(request);
		String password = obtainPassword(request);

		//System.out.println(username + " - " + password);
		System.out.println(username);
		
		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		
		
		SimpleUrlAuthenticationSuccessHandler success = new SimpleUrlAuthenticationSuccessHandler();
		SimpleUrlAuthenticationFailureHandler failed = new SimpleUrlAuthenticationFailureHandler();
	
		if(request.getParameter("origen").equals("default"))
		{
			failed.setDefaultFailureUrl("/login/loginfailed");
			success.setDefaultTargetUrl("/login/loginSuccessful");
		}
		else
		{
			failed.setDefaultFailureUrl("/azumedLogin/loginfailed");
			success.setDefaultTargetUrl("/azumedLogin/loginSuccessful");
		}
			
		this.setAuthenticationFailureHandler(failed);
		this.setAuthenticationSuccessHandler(success);

		setDetails(request, authRequest);
		
		System.out.println( getAuthenticationManager().authenticate(authRequest));

		return getAuthenticationManager().authenticate(authRequest);
	}

	protected String obtainPassword(HttpServletRequest request) {
		return request.getParameter(this.passwordParameter);
	}

	protected String obtainUsername(HttpServletRequest request) {
		return request.getParameter(this.usernameParameter)
				+ "|" +  request.getParameter("rfc");
	}

	protected void setDetails(HttpServletRequest request,
			UsernamePasswordAuthenticationToken authRequest) {
		authRequest.setDetails(this.authenticationDetailsSource
				.buildDetails(request));
	}

	public void setUsernameParameter(String usernameParameter) {
		Assert.hasText(usernameParameter,
				"Username parameter must not be empty or null");
		this.usernameParameter = usernameParameter;
	}

	public void setPasswordParameter(String passwordParameter) {
		Assert.hasText(passwordParameter,
				"Password parameter must not be empty or null");
		this.passwordParameter = passwordParameter;
	}

	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	public final String getUsernameParameter() {
		return this.usernameParameter;
	}

	public final String getPasswordParameter() {
		return this.passwordParameter;
	}
}