package com.thoughtworks.wechat.net;

import com.thoughtworks.wechat.Constants;
import com.thoughtworks.wechat.net.response.Moments;
import com.thoughtworks.wechat.net.response.UserInfo;
import com.thoughtworks.wechat.net.subscriber.DataSubscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static volatile RetrofitFactory instance = null;

    public static RetrofitFactory getInstance() {
        if (instance == null) {
            synchronized (RetrofitFactory.class) {
                if (instance == null) {
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

    private RetrofitFactory() {

    }

    /**
     * 构建okHttpBuilder
     */
    private OkHttpClient.Builder getClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //控制网络请求日志打印，正式环境应禁用此拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        return builder;
    }

    /**
     * 构建本平台baseUrl对应到retrofit
     */
    private RetrofitService getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(getClientBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(RetrofitService.class);
    }

    /**
     * 获取动态列表
     */
    public void getTweets(DataSubscriber<List<Moments>> scheduler) {
        getRetrofit().getTweets().compose(RxUtils.applyFSchedulers()).compose(RxUtils.handleDataResponse()).subscribe(scheduler);
    }

    /**
     * 获取用户信息
     */
    public void getUserInfo(DataSubscriber<UserInfo> scheduler) {
        getRetrofit().getUserInfo().compose(RxUtils.applyFSchedulers()).compose(RxUtils.handleDataResponse()).subscribe(scheduler);
    }
}
