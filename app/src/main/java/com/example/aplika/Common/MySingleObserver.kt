package com.example.aplika.Common

import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber
// make coustome single observer for all ViewModel
abstract class MySingleObserver<T> (val compositeDisposable: CompositeDisposable):SingleObserver<T>{


    override fun onError(e: Throwable) {
        Timber.e(e)
       //  EventBus.getDefault().post(MyExceptionMapper.map(e))
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)

    }
}