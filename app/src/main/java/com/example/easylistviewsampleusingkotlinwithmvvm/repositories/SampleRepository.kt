package com.example.easylistviewsampleusingkotlinwithmvvm.repositories

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk.APIClient
import com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk.APIInterface
import com.example.easylistviewsampleusingkotlinwithmvvm.easylistviewsdk.ApiCallBackResponse
import com.example.easylistviewsampleusingkotlinwithmvvm.responses.DashboardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SampleRepository {

    fun getTotalProductItems(context: Context, apiCallBackResponse: ApiCallBackResponse): MutableLiveData<DashboardResponse> {

        val totalProductData = MutableLiveData<DashboardResponse>()


        var apiInterface: APIInterface = APIClient.getClient().create(APIInterface::class.java)
        val call1 = apiInterface.getDashboardItems()
        call1.enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        if (response.body()?.result != null) {
                            if (response.body()?.result.equals("success", true)) {
                                totalProductData.value = response.body()
                            } else {
                                Toast.makeText(context, "Response result failed", Toast.LENGTH_LONG)
                                    .show()
                            }
                        } else {
                            Toast.makeText(context, "No result found", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(context, "Record not found", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                call.cancel()
            }
        })

        return totalProductData
    }

}


















//        val userDetails: HashMap<String, String> = UserSessionManager.getInstance(context).sessionDetails
//        val service = Util.getService(context)
//        val authorization =
//            if (userDetails.get(UserSessionManager.KEY_JWT) != null) userDetails.get(UserSessionManager.KEY_JWT) else ""
//        val url = Util.generateURL(context, R.string.api_process, "products/$productFilterBase64")

//        if (service != null) {
//            service.getTotalProductListItems(authorization, url)
//                .enqueue(
//                    CustomRetrofitCallback<TotalProductListResponse>(
//                        context,
//                        apiCallBackResponse,
//                        object : Callback<TotalProductListResponse> {
//                            override fun onResponse(
//                                call: Call<TotalProductListResponse>,
//                                response: Response<TotalProductListResponse>
//                            ) {
//                                if (response.isSuccessful) {
//                                    if (response.body() != null) {
//                                        if (response.body()?.result != null) {
//                                            if (response.body()?.result.equals("success", true)) {
//                                                totalProductData.value = response.body()
//                                            } else {
//                                                Toast.makeText(context, "Response result failed", Toast.LENGTH_LONG)
//                                                    .show()
//                                            }
//                                        } else {
//                                            Toast.makeText(context, "No result found", Toast.LENGTH_LONG).show()
//                                        }
//                                    } else {
//                                        Toast.makeText(context, "Record not found", Toast.LENGTH_LONG).show()
//                                    }
//                                } else {
//                                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
//                                }
//                            }
//
//                            override fun onFailure(call: Call<TotalProductListResponse>, t: Throwable) {
//                                Toast.makeText(context, "Unable to connect to internet!", Toast.LENGTH_LONG).show()
//                            }
//                        }
//                    ))
//        }
//        return totalProductData
//    }
//
//}