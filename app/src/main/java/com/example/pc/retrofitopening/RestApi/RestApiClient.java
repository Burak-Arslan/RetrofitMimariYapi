package com.example.pc.retrofitopening.RestApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private RestApi restApi;

    public RestApiClient(String restApiServiceURL) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.MINUTES)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(restApiServiceURL)
                    // .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            restApi = retrofit.create(RestApi.class);

        } catch (Exception ex) {

        }
    }

    public RestApi restApi() {
        return restApi;
    }
}

