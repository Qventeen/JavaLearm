package com.jr.level.level36.task3608.view;

import com.jr.level.level36.task3608.bean.User;
import com.jr.level.level36.task3608.controller.Controller;
import com.jr.level.level36.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList())
            System.out.println("All deleted users:");
        else
            System.out.println("All users:");

        for(User u: modelData.getUsers()){
            System.out.println("\t" + u);
        }
        for(int i = 0; i <= 50; i++){
            System.out.print('=');
        }
        System.out.println();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers(){
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id){
        controller.onOpenUserEditForm(id);
    }

}
