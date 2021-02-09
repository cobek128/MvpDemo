package com.example.romanticdemo;

public interface IMvpModel {
    /**
     * 数据请求成功
     * @param data  请求的数据
     */
    void onSuccess(String data);

    /**
     * 由于msg原因，数据请求失败
     * @param msg   失败原因
     */
    void onFailure(String msg);

    /**
     * 由于网络差、缺少权限等原因导致数据请求异常
     */
    void onError();

    /**
     * 无论数据请求成功、失败或是异常，都调用该方法
     */
    void onComplete();
}
