package com.ardakaplan.rdalibrary.base.objects;

public interface RDAPresenterContract<TView extends RDAViewContract> {

    void attach(TView tView);
    void detach();

}
