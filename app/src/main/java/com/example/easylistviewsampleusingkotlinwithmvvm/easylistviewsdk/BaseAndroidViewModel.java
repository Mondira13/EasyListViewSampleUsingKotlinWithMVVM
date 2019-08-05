package com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Base class of all ViewModel classes
 */
public class BaseAndroidViewModel extends AndroidViewModel implements ApiCallBackResponse {
    protected SingleLiveEvent<Boolean> isLoading = new SingleLiveEvent<>();

    public BaseAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * this Live data method is being observed from BaseActivity and BaseFragment
     * @return LiveData
     */
    public LiveData<Boolean> showProgress() {
        if (isLoading == null) {
            isLoading = new SingleLiveEvent<>();
        }
        return isLoading;
    }


    /**
     * Callback when api call response failed
     */
    @Override
    public void onFail() {
        if (isLoading!=null) {
            isLoading.setValue(false);
        }
    }

    /**
     * Callback when api call response success
     */
    @Override
    public void onSuccess() {
        if (isLoading!=null) {
            isLoading.setValue(false);
        }
    }

    /**
     * Callback when api call initiated
     * This method must be called before every repository call
     */
    protected void startLoading() {
        if (isLoading!=null) {
            isLoading.setValue(true);
        }
    }
}
