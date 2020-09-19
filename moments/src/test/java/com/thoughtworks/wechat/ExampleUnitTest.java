package com.thoughtworks.wechat;

import com.thoughtworks.wechat.mvp.presenter.MomentsActivityPresenter;
import com.thoughtworks.wechat.net.RetrofitFactory;
import com.thoughtworks.wechat.net.response.UserInfo;
import com.thoughtworks.wechat.net.subscriber.DataSubscriber;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}