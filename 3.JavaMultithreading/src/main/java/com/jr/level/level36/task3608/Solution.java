package com.jr.level.level36.task3608;

import com.jr.level.level36.task3608.controller.Controller;
import com.jr.level.level36.task3608.model.MainModel;
import com.jr.level.level36.task3608.model.Model;
import com.jr.level.level36.task3608.view.EditUserView;
import com.jr.level.level36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.setController(controller);
        editUserView.setController(controller);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Sidorchuk",123,3);
        usersView.fireEventShowDeletedUsers();
    }
}
