package com.guicedee.primefaces.showcase.implementations;

import com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator;
import io.undertow.servlet.api.*;

public class ShowcaseDeploymentConfiguration implements UndertowDeploymentConfigurator
{
	@Override
	public DeploymentInfo configure(DeploymentInfo deploymentInfo)
	{
		deploymentInfo.addInitParameter("jakarta.faces.FACELETS_LIBRARIES","/WEB-INF/showcase.taglib.xml");

		deploymentInfo.addInitParameter("jakarta.faces.PROJECT_STAGE","Development");

		deploymentInfo.addInitParameter("primefaces.FONT_AWESOME","true");
		deploymentInfo.addInitParameter("primefaces.THEME","#{empty userSettings ? 'nova-light' : userSettings.currentTheme.name}");
		deploymentInfo.addInitParameter("primefaces.MOVE_SCRIPTS_TO_BOTTOM","true");
		deploymentInfo.addInitParameter("primefaces.CSP","false");

		deploymentInfo.addInitParameter("jakarta.faces.FACELETS_REFRESH_PERIOD","-1");
		deploymentInfo.addInitParameter("jakarta.faces.FACELETS_SKIP_COMMENTS","true");
		deploymentInfo.addInitParameter("jakarta.faces.VALIDATE_EMPTY_FIELDS","true");
		deploymentInfo.addInitParameter("jakarta.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE","true");
		deploymentInfo.addInitParameter("jakarta.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL","true");
		deploymentInfo.addInitParameter("jakarta.faces.STATE_SAVING_METHOD","server");


		deploymentInfo.addInitParameter("com.sun.faces.resourceUpdateCheckPeriod","-1");
		deploymentInfo.addInitParameter("com.sun.faces.allowTextChildren","true");
		deploymentInfo.addInitParameter("com.sun.faces.defaultResourceMaxAge","1209600000");
		deploymentInfo.addInitParameter("com.sun.faces.enableMissingResourceLibraryDetection","true");
		deploymentInfo.addInitParameter("com.sun.faces.numberOfViewsInSession","5");
		deploymentInfo.addInitParameter("com.sun.faces.serializeServerState","false");


		deploymentInfo.addListener(new ListenerInfo(com.sun.faces.config.ConfigureListener.class));

		deploymentInfo.addErrorPage(new ErrorPage("/views/error/throwable.jsf", Throwable.class));
		deploymentInfo.addErrorPage(new ErrorPage("/views/error/viewExpired.jsf", jakarta.faces.application.ViewExpiredException.class));

		deploymentInfo.addWelcomePage("/index.xhtml");

		return deploymentInfo;
	}
}
