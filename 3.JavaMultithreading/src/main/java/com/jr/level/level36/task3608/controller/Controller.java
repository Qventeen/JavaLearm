package com.jr.level.level36.task3608.controller;

import com.jr.level.level36.task3608.model.Model;
import com.jr.level.level36.task3608.view.EditUserView;
import com.jr.level.level36.task3608.view.UsersView;


public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    //Setters
    public void setModel(Model model){
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView){
        this.editUserView = editUserView;
    }

    //Show
    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers(){
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userid){
        model.loadUserById(userid);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level){
        model.changeUserData(name,id,level);
        usersView.refresh(model.getModelData());
    }

}
