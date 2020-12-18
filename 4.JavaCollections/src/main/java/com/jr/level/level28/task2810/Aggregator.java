package com.jr.level.level28.task2810;


import com.jr.level.level28.task2810.model.LinkedInStrategy;
import com.jr.level.level28.task2810.model.Model;
import com.jr.level.level28.task2810.model.Provider;
import com.jr.level.level28.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider(new LinkedInStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
