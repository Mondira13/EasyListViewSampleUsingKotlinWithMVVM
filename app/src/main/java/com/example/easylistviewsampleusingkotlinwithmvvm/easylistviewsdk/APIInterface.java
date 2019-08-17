package com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk;


import com.example.easylistviewsampleusingkotlinwithmvvm.responses.DashboardResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/bins/14v8oz")
    Call<DashboardResponse> getDashboardItems();

}

//      https://api.myjson.com/bins/14v8oz
