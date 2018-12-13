package com.ardakaplan.rdalibrary.objects.base;

public interface RDAPresenterContract<TView extends RDAViewContract> {

    void attach(TView tView);
    void detach();

}
