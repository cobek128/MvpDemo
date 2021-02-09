package com.example.romanticdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.romanticdemo.base.BaseActivity;

public class MainActivity extends BaseActivity implements MvpView {
    TextView text;
    MvpPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        mvpPresenter = new MvpPresenter(getContext());
        mvpPresenter.attachView(this);      // 绑定view
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpPresenter.unAttachView();    // 解绑view
    }

    public void getData(View view) {
        mvpPresenter.getData("normal");
    }

    public void getFailureData(View view) {
        mvpPresenter.getData("failure");
    }

    public void getErrorData(View view) {
        mvpPresenter.getData("error");
    }

    @Override
    public void showData(String data) {
        showToast(getResources().getString(R.string.api_success_msg));
        text.setText(data);
    }
}