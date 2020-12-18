package com.jr.level.level28.task2810.model;

import com.jr.level.level28.task2810.vo.Vacancy;
import java.util.List;

public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
