package com.thoughtworks.wechat.mvp.base;


import java.lang.ref.WeakReference;

public abstract class BaseActivityPresenterImp<V extends BaseActivityView> implements BaseActivityPresenter {
    private WeakReference<V> view;

    public void attachView(V view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (view.get() != null) {
            view.clear();
        }
        view = null;
    }

    protected V getView() {
        if (view == null || view.get() == null) {
            return null;
        }
        return view.get();
    }
}
