package com.example.romanticdemo;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.romanticdemo.base.BasePresenter;

public class MvpPresenter extends BasePresenter<MvpView > {
//    private MvpView mvpView;

    // 构造函数
//    public MvpPresenter (MvpView view) {
//        this.mvpView = view;
//    }
    private final Context mContext;

    public MvpPresenter(Context context) {
        this.mContext = context;
    }

    // 绑定view
//    public void attachView(MvpView view) {
//        this.mvpView = view;
//    }

    //解绑view
//    public void unAttachView() {
//        this.mvpView = null;
//    }

    // 是否绑定view
//    public boolean isAttachedView() {
//        return this.mvpView != null;
//    }
    // 获取网络数据
    public void getData(String params) {
        if (!isAttachedView()) {
            //若没有view引用，则不加载数据
            return;
        }
        // 显示正在加载框
        getView().showLoading();
        MvpModel.getNetData(params, new IMvpModel<String>() {
            @Override
            public void onSuccess(String data) {
                if (isAttachedView()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isAttachedView()) {
                    getView().showToast(msg);
                    getView().showData(msg);
                }
            }

            @Override
            public void onError() {
                if (isAttachedView()) {
                    getView().showError();
                    getView().showData(mContext.getString(R.string.api_get_error_data));
                }
            }

            @Override
            public void onComplete() {
                if (isAttachedView()) {
                    getView().hideLoading();
                }
            }
        });
    }
}
