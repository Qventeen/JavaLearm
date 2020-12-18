package com.jr.level.level28.task2810.model;

import com.jr.level.level28.task2810.view.View;
import com.jr.level.level28.task2810.vo.Vacancy;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private Provider[] providers;
    private View view;

    public Model(View view, Provider ... providers) {
        if(providers == null || view == null || providers.length == 0){
            throw new IllegalArgumentException();
        }
        this.providers = providers;
        this.view = view;
    }

    public void selectCity(String city){
        if(city == null) city = "";

        List<Vacancy> vacancies = new ArrayList<>();
        for(Provider provider: providers){
            if(provider != null){
                vacancies.addAll(provider.getJavaVacancies(city));
            }
        }
        view.update(vacancies);
    }


}
