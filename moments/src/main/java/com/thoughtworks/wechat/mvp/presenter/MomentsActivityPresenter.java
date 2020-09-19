package com.thoughtworks.wechat.mvp.presenter;


import com.thoughtworks.wechat.mvp.base.BaseActivityPresenterImp;
import com.thoughtworks.wechat.mvp.contract.MomentsActivityContract;
import com.thoughtworks.wechat.net.RetrofitFactory;
import com.thoughtworks.wechat.net.response.Moments;
import com.thoughtworks.wechat.net.response.UserInfo;
import com.thoughtworks.wechat.net.subscriber.DataSubscriber;

import java.util.List;

import javax.inject.Inject;

public class MomentsActivityPresenter extends BaseActivityPresenterImp<MomentsActivityContract.View> implements MomentsActivityContract.Presenter{
    @Inject
    public MomentsActivityPresenter() {
    }

    @Override
    public void start() {
        getUserInfo();
        getTweets();
    }

    @Override
    public void getUserInfo() {
        RetrofitFactory.getInstance().getUserInfo(new DataSubscriber<UserInfo>() {
            @Override
            protected void success(UserInfo data) {
                if (getView() != null){
                    getView().getUserInfoSuccess(data);
                }
            }
        });
    }

    @Override
    public void getTweets() {
        RetrofitFactory.getInstance().getTweets(new DataSubscriber<List<Moments>>() {
            @Override
            protected void success(List<Moments> data) {
                if (getView() != null){
                    getView().getTweetsSuccess(data);
                }
            }
        });
    }
}
