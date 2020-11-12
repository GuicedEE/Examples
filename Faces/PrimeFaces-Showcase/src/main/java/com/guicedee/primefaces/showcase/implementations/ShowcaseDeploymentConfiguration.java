package com.guicedee.primefaces.showcase.implementations;

import com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator;
import io.undertow.servlet.api.*;

public class ShowcaseDeploymentConfiguration implements UndertowDeploymentConfigurator
{
	@Override
	public DeploymentInfo configure(DeploymentInfo deploymentInfo)
	{
		deploymentInfo.addInitParameter("jakarta.faces.FACELETS_LIBRARIES","/WEB-INF/showcase.taglib.xml");
		deploymentInfo.addInitParameter("jakarta.faces.STATE_SAVING_METHOD","server");
		deploymentInfo.addInitParameter("jakarta.faces.PROJECT_STAGE","Development");
		deploymentInfo.addInitParameter("jakarta.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE","true");
		deploymentInfo.addInitParameter("jakarta.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL","true");
		deploymentInfo.addInitParameter("primefaces.PRIVATE_CAPTCHA_KEY","6Lf2XQkTAAAAAHsc1-7Mt_kMlmcmGqlxoMDJlp2K");
		deploymentInfo.addInitParameter("primefaces.PUBLIC_CAPTCHA_KEY","6Lf2XQkTAAAAANcvOwYqPxWL4iZDksFqHpS39GDA");
		deploymentInfo.addInitParameter("primefaces.CLIENT_SIDE_VALIDATION","true");
		deploymentInfo.addInitParameter("primefaces.FONT_AWESOME","true");
		deploymentInfo.addInitParameter("primefaces.THEME","#{guestPreferences.theme}");
		deploymentInfo.addInitParameter("primefaces.MOVE_SCRIPTS_TO_BOTTOM","true");
		deploymentInfo.addInitParameter("primefaces.CSP","false");
		deploymentInfo.addInitParameter("primefaces.TRANSFORM_METADATA","true");
		deploymentInfo.addInitParameter("com.sun.faces.numberOfViewsInSession","5");
		deploymentInfo.addInitParameter("primefaces.MULTI_VIEW_STATE_STORE","client-window");
		deploymentInfo.addInitParameter("com.sun.faces.serializeServerState","false");

		deploymentInfo.addFilter(new FilterInfo("Character Encoding Filter", org.primefaces.showcase.filter.CharacterEncodingFilter.class));

		deploymentInfo.addListener(new ListenerInfo(com.sun.faces.config.ConfigureListener.class));

		deploymentInfo.addErrorPage(new ErrorPage("/error.xhtml", Throwable.class));
		deploymentInfo.addErrorPage(new ErrorPage("/viewExpired.xhtml", jakarta.faces.application.ViewExpiredException.class));
		deploymentInfo.addErrorPage(new ErrorPage("/error.xhtml", 404));

		
		
		deploymentInfo.addWelcomePage("/index.xhtml");

		return deploymentInfo;
	}
}
