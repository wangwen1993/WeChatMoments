package com.thoughtworks.wechat.mvp.base.dagger.component;


import com.thoughtworks.wechat.mvp.base.dagger.module.ActivityModule;
import com.thoughtworks.wechat.mvp.base.dagger.scope.ActivityScope;
import com.thoughtworks.wechat.mvp.view.MomentsActivity;

import dagger.Component;

/**
 * NetComponent 单例网络接口api
 * 将presenter注入到baseActivity的子类中
 */
@ActivityScope
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MomentsActivity activity);

}