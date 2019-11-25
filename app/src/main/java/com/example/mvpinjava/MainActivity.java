package com.example.mvpinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpinjava.Model.LoginInteractor;
import com.example.mvpinjava.Presenter.LoginPresenter;
import com.example.mvpinjava.View.Error;
import com.example.mvpinjava.View.Home;
import com.example.mvpinjava.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private EditText userName;
    private EditText password;
    private Button loginBtn;
    private ProgressBar progressBar;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.username_etxt);
        password=findViewById(R.id.password_etxt);
        loginBtn=findViewById(R.id.login_btn);
        progressBar=findViewById(R.id.loginProgressBar);
        presenter= new LoginPresenter(this, new LoginInteractor());
    }

    @Override
    public void onResume(){
        super.onResume();
        userName.setAlpha(1);
        password.setAlpha(1);
        loginBtn.setAlpha(1);
        progressBar.setAlpha(0);
    }
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        if(message=="Success")
            startActivity(new Intent(this,Home.class));
        else
            startActivity(new Intent(this, Error.class));
    }

    public void validatePresenter(View view) {
        presenter.validate(userName.getText().toString(),password.getText().toString());
    }
}
