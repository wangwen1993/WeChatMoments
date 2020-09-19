package com.thoughtworks.wechat.net.subscriber;

import android.accounts.NetworkErrorException;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

public abstract class DataSubscriber<T> extends ResourceSubscriber<T> {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T response) {
        //成功
        success(response);
    }

    @Override
    public void onError(Throwable t) {
        //此处可对异常进行比较分析，如请求超时、JSON解析异常等，可做对应提示
        if (t instanceof TimeoutException
                || t instanceof NetworkErrorException || t instanceof HttpException
                || t instanceof IOException || t instanceof JsonSyntaxException) {
            //doSomething
        }
        failed();
    }

    @Override
    public void onComplete() {

    }

    /**
     * 获取接口数据成功，将数据结果集返回
     *
     * @param data 接口返回数据
     */
    protected abstract void success(T data);


    /**
     * 接口调用失败
     */
    protected void failed() {

    }
}
