package com.thoughtworks.wechat.net;

import com.thoughtworks.wechat.net.response.Moments;
import com.thoughtworks.wechat.net.response.UserInfo;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface RetrofitService {

    /**
     * 获取动态列表
     */
    @GET("/user/jsmith/tweets")
    Flowable<List<Moments>> getTweets();

    /**
     * 获取用户信息
     */
    @GET("/user/jsmith")
    Flowable<UserInfo> getUserInfo();
}
