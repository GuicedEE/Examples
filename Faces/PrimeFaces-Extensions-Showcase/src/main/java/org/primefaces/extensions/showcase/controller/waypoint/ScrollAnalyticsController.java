/*
 * Copyright 2011-2020 PrimeFaces Extensions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.extensions.showcase.controller.waypoint;

import java.io.Serializable;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.ContextCallback;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlPanelGroup;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.primefaces.extensions.event.WaypointEvent;

/**
 * WaypointController
 *
 * @author Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@Named
@ViewScoped
public class ScrollAnalyticsController implements Serializable {

    private static final long serialVersionUID = 20120816L;

    public void adInView(final WaypointEvent e) {
        final UIComponent container = e.getComponent().findComponent("container");

        container.invokeOnComponent(FacesContext.getCurrentInstance(), e.getWaypointId(), new ContextCallback() {

            @Override
            public void invokeContextCallback(final FacesContext fc, final UIComponent component) {
                final HtmlPanelGroup panelGroup = (HtmlPanelGroup) component;
                final String analyticsId = panelGroup != null ? (String) panelGroup.getAttributes().get("analyticsid")
                            : "";

                final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Ad with ID: " + analyticsId + " was read", null);
                fc.addMessage(null, msg);
            }
        });
    }
}
