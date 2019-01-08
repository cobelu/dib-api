package com.cobelu.dib.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	/*
	 * By default, form login will answer a successful authentication request with a
	 * 301 MOVED PERMANENTLY status code; this makes sense in the context of an
	 * actual login form which needs to redirect after login.
	 * 
	 * However, for a RESTful web service, the desired response for a successful
	 * authentication should be 200 OK.
	 * 
	 * We do this by injecting a custom authentication success handler in the form
	 * login filter, to replace the default one. The new handler implements the
	 * exact same login as the default
	 * org.springframework.security.web.authentication.
	 * SavedRequestAwareAuthenticationSuccessHandler with one notable difference –
	 * it removes the redirect logic
	 * 
	 * https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
	 */

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest == null) {
			clearAuthenticationAttributes(request);
			return;
		}
		String targetUrlParam = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
			requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
			return;
		}

		clearAuthenticationAttributes(request);
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}