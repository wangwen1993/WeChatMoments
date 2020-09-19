package com.thoughtworks.wechat.mvp.base;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


import com.thoughtworks.wechat.mvp.base.dagger.component.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity<P extends BaseActivityPresenterImp> extends AppCompatActivity implements BaseActivityView {
    @Inject
    P mPresenter;
    protected Context mContext;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mContext = this;
        ButterKnife.bind(this);
        //根据dagger注入从baseActivity取到component，子类根据component.inject()方法注入到当前activity实例
        presenterInject(DaggerActivityComponent.builder().build());
        mPresenter.attachView(this);
        initData(getIntent().getExtras());
        mCompositeDisposable = new CompositeDisposable();
        mPresenter.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mPresenter = null;
        clearDisposable();
        super.onDestroy();
    }

    /**
     * 添加订阅
     */
    public void addDisposable(Disposable mDisposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(mDisposable);
    }

    /**
     * UI层销毁时，取消所有订阅
     */
    public void clearDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
