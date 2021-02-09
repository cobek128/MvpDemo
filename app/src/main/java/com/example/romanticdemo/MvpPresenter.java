package com.example.romanticdemo;

public class MvpPresenter {
    private MvpView mvpView;
    // 构造函数
    public MvpPresenter (MvpView view) {
        this.mvpView = view;
    }

    // 获取网络数据
    public void getData(String params) {
        // 显示正在加载框
        mvpView.showLoading();
        MvpModel.getNetData(params, new IMvpModel() {
            @Override
            public void onSuccess(String data) {
                mvpView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.showFailureMsg(msg);
            }

            @Override
            public void onError() {
                mvpView.showErrorMsg();
            }

            @Override
            public void onComplete() {
                mvpView.hideLoading();
            }
        });
    }
}
