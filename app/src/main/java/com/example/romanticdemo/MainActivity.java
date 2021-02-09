package com.example.romanticdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MvpView {
    // 进度条
    ProgressDialog progressDialog;
    TextView text;
    MvpPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        mvpPresenter = new MvpPresenter(this);
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
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        Toast.makeText(this, "请求数据成功", Toast.LENGTH_SHORT).show();
        text.setText(data);
    }

    @Override
    public void showFailureMsg(String msg) {
        Toast.makeText(this, "请求数据失败", Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(this, "请求数据异常", Toast.LENGTH_SHORT).show();
        text.setText("数据请求异常，可能是由于网络差、没有权限等原因");
    }
}