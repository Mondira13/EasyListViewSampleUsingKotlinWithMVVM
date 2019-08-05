package com.example.easylistviewsampleusingkotlinwithmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk.BaseAndroidViewModel
import com.example.easylistviewsampleusingkotlinwithmvvm.repositories.SampleRepository
import com.example.easylistviewsampleusingkotlinwithmvvm.responses.DashboardResponse

class SampleViewModel(application: Application)  : BaseAndroidViewModel(application) {

    // declare MutableLiveData reference variable & initial with null value
    var mTotalProductListData: MutableLiveData<DashboardResponse>? = null


    fun getListOfData(): MutableLiveData<DashboardResponse> {
        // if MutableLiveData reference variable is null then initial it with MutableLiveData object
        if (mTotalProductListData == null) {
            mTotalProductListData = MutableLiveData()
        }

        /**
         *  visible progress bar
         */
        startLoading()

        //  get list of datas from repository & initial it in MutableLiveData reference variable
        mTotalProductListData = SampleRepository().getTotalProductItems(getApplication<Application>(), this)

        // return MutableLiveData reference variable
        return mTotalProductListData as MutableLiveData<DashboardResponse>
    }


}