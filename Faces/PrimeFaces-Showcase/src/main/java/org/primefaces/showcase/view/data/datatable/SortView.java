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
package org.primefaces.showcase.view.data.datatable;

import jakarta.faces.view.ViewScoped;

import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.primefaces.showcase.domain.Car;
import org.primefaces.showcase.service.CarService;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dtSortView")
@ViewScoped
public class SortView implements Serializable {
    
    private List<Car> cars1;
    private List<Car> cars2;
    private List<Car> cars3;
    private List<SortMeta> sortBy;

    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars1 = service.createCars(10);
        cars2 = service.createCars(10);
        cars3 = service.createCars(50);

        sortBy = new ArrayList<>();
        sortBy.add(SortMeta.builder()
                .field("year")
                .order(SortOrder.ASCENDING)
                .build());

        sortBy.add(SortMeta.builder()
                .field("color")
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
    }

    public List<Car> getCars1() {
        return cars1;
    }

    public List<Car> getCars2() {
        return cars2;
    }
    
    public List<Car> getCars3() {
        return cars3;
    }

    public List<SortMeta> getSortBy() {
        return sortBy;
    }

    public void setService(CarService service) {
        this.service = service;
    }
}
