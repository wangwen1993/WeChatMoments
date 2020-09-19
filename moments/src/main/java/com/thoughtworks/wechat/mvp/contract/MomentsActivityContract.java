package com.thoughtworks.wechat.mvp.contract;

import com.thoughtworks.wechat.mvp.base.BaseActivityPresenter;
import com.thoughtworks.wechat.mvp.base.BaseActivityView;
import com.thoughtworks.wechat.net.response.Moments;
import com.thoughtworks.wechat.net.response.UserInfo;

import java.util.List;

public interface MomentsActivityContract {
    interface View extends BaseActivityView{
        void getUserInfoSuccess(UserInfo data);

        void getTweetsSuccess(List<Moments> data);
    }

    interface Presenter extends BaseActivityPresenter{
        void getUserInfo();

        void getTweets();
    }
}
