package com.example.romanticdemo;

public interface MvpView {
    /**
     * 显示正在加载框
     */
    void showLoading();

    /**
     * 隐藏正在加载框
     */
    void hideLoading();

    /**
     * 显示请求数据
     * @param data 请求数据
     */
    void showData(String data);

    /**
     * 显示数据请求失败原因
     * @param msg 失败原因
     */
    void showFailureMsg(String msg);

    /**
     * 显示数据请求异常原因
     */
    void showErrorMsg();
}
