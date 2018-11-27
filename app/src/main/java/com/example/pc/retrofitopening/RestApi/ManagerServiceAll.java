package com.example.pc.retrofitopening.RestApi;


import com.example.pc.retrofitopening.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;

public class ManagerServiceAll extends BaseManager {

    private static ManagerServiceAll ourInstance = new ManagerServiceAll();

    public static synchronized ManagerServiceAll getOurInstance() {
        return ourInstance;
    }

    public Call<List<Bilgiler>> bilgileriGetir() {
        Call<List<Bilgiler>> call = getRestApiClient().bilgiGetir();
        return call;
    }
}
