package com.example.romanticdemo;

import android.os.Handler;

public class MvpModel {
    /**
     * 获取网络数据
     * @param params
     * @param iMvpModel
     */
    public static void getNetData(final String params, final IMvpModel iMvpModel) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (params) {
                    case "normal":
                        iMvpModel.onSuccess("请求数据成功");
                        break;
                    case "failure":
                        iMvpModel.onFailure("参数有误，请求数据失败");
                        break;
                    case "error":
                        iMvpModel.onError();
                        break;
                }
                iMvpModel.onComplete();
            }
        }, 5000);
    }
}
