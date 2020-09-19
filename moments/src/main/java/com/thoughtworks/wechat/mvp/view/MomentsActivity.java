package com.thoughtworks.wechat.mvp.view;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.wechat.R;
import com.thoughtworks.wechat.mvp.base.BaseActivity;
import com.thoughtworks.wechat.mvp.base.dagger.component.ActivityComponent;
import com.thoughtworks.wechat.mvp.contract.MomentsActivityContract;
import com.thoughtworks.wechat.mvp.presenter.MomentsActivityPresenter;
import com.thoughtworks.wechat.net.RetrofitFactory;
import com.thoughtworks.wechat.net.response.Moments;
import com.thoughtworks.wechat.net.response.UserInfo;
import com.thoughtworks.wechat.net.subscriber.DataSubscriber;

import java.util.List;

public class MomentsActivity extends BaseActivity<MomentsActivityPresenter> implements MomentsActivityContract.View {

    @Override
    public void presenterInject(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_moments;
    }

    @Override
    public void initData(Bundle extras) {

    }


    @Override
    public void getTweetsSuccess(List<Moments> data) {

    }

    @Override
    public void getUserInfoSuccess(UserInfo data) {

    }
}
