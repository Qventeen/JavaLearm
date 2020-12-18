package com.jr.level.level36.task3608.view;

import com.jr.level.level36.task3608.controller.Controller;
import com.jr.level.level36.task3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
