package com.android.oda.appUtilities.base

import androidx.lifecycle.ViewModel
import com.android.oda.appUtilities.network.ApiResponseWrapper.*
import com.android.oda.appUtilities.util.livedata.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    var showProgress: SingleLiveEvent<Boolean?> = SingleLiveEvent()
    var responseError: SingleLiveEvent<Failure> = SingleLiveEvent()

    protected fun showProgress(showProgress: Boolean) {
        this.showProgress.postValue(showProgress)
    }

    protected fun handleFailure(failure: Failure) {
        responseError.postValue(failure)
    }
}