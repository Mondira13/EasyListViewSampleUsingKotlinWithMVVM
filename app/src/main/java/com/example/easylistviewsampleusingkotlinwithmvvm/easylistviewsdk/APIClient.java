package com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {


        OkHttpClient client = new OkHttpClient.Builder().build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com")
                .addConverterFactory(GsonConverterFactory.create()) // convert string to object
                .client(client) // its a http client object
                .build();


        return retrofit; // its create for call api
    }
}
