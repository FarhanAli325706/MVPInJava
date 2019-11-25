package com.example.mvpinjava.Model;

import com.example.mvpinjava.Presenter.ILoginPresenter;

public class LoginInteractor {
    private ILoginPresenter presenter=null;
    public void addPresenter(ILoginPresenter p)
    {
        this.presenter=p;
    }
    public void authenticate(String username, String password) {
        if(username.isEmpty() || password.isEmpty())
        {
            this.presenter.validated(false);
        }
        else if((username=="hamza") && (password=="123"))
        {
            this.presenter.validated(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            this.presenter.validated(false);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
