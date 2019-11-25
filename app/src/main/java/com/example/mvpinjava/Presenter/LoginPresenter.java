package com.example.mvpinjava.Presenter;

import com.example.mvpinjava.Model.LoginInteractor;
import com.example.mvpinjava.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    private ILoginView view;
    private LoginInteractor interactor;
    public LoginPresenter(ILoginView i , LoginInteractor m)
    {
        this.view=i;
        this.interactor=m;
    }
    public void validate(String useraname , String password)
    {
        this.interactor.addPresenter(this);
        this.interactor.authenticate(useraname,password);
    }
    @Override
    public void validated(Boolean answer) {
        if(answer)
            this.view.showToast("Success");
        else
            this.view.showToast("Failed");
    }
}
