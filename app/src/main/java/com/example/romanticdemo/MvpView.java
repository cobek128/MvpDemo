package com.example.romanticdemo;

import com.example.romanticdemo.base.BaseView;

public interface MvpView  extends BaseView {
    /**
     * 显示请求数据
     * @param data 请求数据
     */
    void showData(String data);
}
