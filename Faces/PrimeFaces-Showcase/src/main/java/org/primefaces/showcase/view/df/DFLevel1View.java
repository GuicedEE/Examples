/*
 * Copyright 2009-2014 PrimeTek.
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
package org.primefaces.showcase.view.df;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named("dfLevel1View")
@RequestScoped
public class DFLevel1View {
    
    public void openLevel2() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("level2", options, null);
    }
    
    public void onReturnFromLevel2(SelectEvent event) {
        //pass back to root
        PrimeFaces.current().dialog().closeDynamic(event.getObject());
    }
}
