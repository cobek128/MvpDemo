package com.example.romanticdemo.base;

import android.content.Context;

public interface BaseView {
    /**
     * 显示正在加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();

    /**
     * 提示
     * @param msg 提示内容
     */
    void showToast(String msg);

    /**
     * 显示请求错误提示
     */
    void showError();

    /**
     * 获取上下文
     * @return
     */
    Context getContext();
}
