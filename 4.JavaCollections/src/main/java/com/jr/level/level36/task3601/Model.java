package com.jr.level.level36.task3601;

import java.util.List;

public class Model {
    private Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }

}
