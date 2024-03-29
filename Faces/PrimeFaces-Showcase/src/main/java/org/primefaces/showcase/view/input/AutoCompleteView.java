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
package org.primefaces.showcase.view.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.showcase.domain.Theme;
import org.primefaces.showcase.service.ThemeService;

@Named
@RequestScoped
public class AutoCompleteView {
    
    private String txt1;
    private String txt2;
    private String txt3;
    private String txt4;
    private String txt5;
    private String txt6;
    private String txt7;
    private String txt8;
    private String txt9;
    private Theme theme1;
    private Theme theme2;
    private Theme theme3;
    private Theme theme4;
    private Theme theme5;
    private List<Theme> selectedThemes;
    
    @Inject
    private ThemeService service;
    
    public List<String> completeText(String query) {
		List<String> results = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			results.add(query + i);
		}
		
		return results;
	}

    public List<String> noResults(String query) {
        return Collections.EMPTY_LIST;
    }
    
    public List<Theme> completeTheme(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Theme> allThemes = service.getThemes();
        return allThemes.stream().filter(t -> t.getName().toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
    
    public List<Theme> completeThemeContains(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Theme> allThemes = service.getThemes();
        return allThemes.stream().filter(t -> t.getName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
	}
        
    public void onItemSelect(SelectEvent<String> event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject()));
    }

    public void onEmptyMessageSelect() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message selected"));
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }

    public String getTxt4() {
        return txt4;
    }

    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }

    public String getTxt5() {
        return txt5;
    }

    public void setTxt5(String txt5) {
        this.txt5 = txt5;
    }

    public String getTxt6() {
        return txt6;
    }

    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    public String getTxt7() {
        return txt7;
    }

    public void setTxt7(String txt7) {
        this.txt7 = txt7;
    }

    public String getTxt8() {
        return txt8;
    }

    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    public String getTxt9() {
        return txt9;
    }

    public void setTxt9(String txt9) {
        this.txt9 = txt9;
    }

    public Theme getTheme1() {
        return theme1;
    }

    public void setTheme1(Theme theme1) {
        this.theme1 = theme1;
    }

    public Theme getTheme2() {
        return theme2;
    }

    public void setTheme2(Theme theme2) {
        this.theme2 = theme2;
    }

    public Theme getTheme3() {
        return theme3;
    }

    public void setTheme3(Theme theme3) {
        this.theme3 = theme3;
    }

    public Theme getTheme4() {
        return theme4;
    }

    public void setTheme4(Theme theme4) {
        this.theme4 = theme4;
    }

    public Theme getTheme5() {
        return theme5;
    }

    public void setTheme5(Theme theme5) {
        this.theme5 = theme5;
    }

    public List<Theme> getSelectedThemes() {
        return selectedThemes;
    }

    public void setSelectedThemes(List<Theme> selectedThemes) {
        this.selectedThemes = selectedThemes;
    }
    
    public void setService(ThemeService service) {
        this.service = service;
    }
    
    public char getThemeGroup(Theme theme) {
        return theme.getDisplayName().charAt(0);
    }
}
