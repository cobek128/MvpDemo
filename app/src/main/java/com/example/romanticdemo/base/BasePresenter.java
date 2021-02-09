package com.example.romanticdemo.base;

public class BasePresenter<V extends BaseView> {
    private V mvpView;
    // 构造函数
    public BasePresenter() {

    }

    /**
     * 绑定view
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    /**
     * 解绑view
     */
    public void unAttachView() {
        this.mvpView = null;
    }

    /**
     * 判断是否连接view
     * @return true or false
     */
    public boolean isAttachedView() {
        return this.mvpView != null;
    }

    /**
     * 获取连接的view
     * @return view
     */
    public V getView() {
        return mvpView;
    }

}
