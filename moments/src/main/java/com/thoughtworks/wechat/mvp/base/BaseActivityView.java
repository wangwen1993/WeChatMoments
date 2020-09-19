package com.thoughtworks.wechat.mvp.base;

import android.os.Bundle;

import com.thoughtworks.wechat.mvp.base.dagger.component.ActivityComponent;


public interface BaseActivityView {
    //设置布局layout
    int setLayout();

    //根据传值完成业务处理
    void initData(Bundle extras);

    void presenterInject(ActivityComponent component);
}
