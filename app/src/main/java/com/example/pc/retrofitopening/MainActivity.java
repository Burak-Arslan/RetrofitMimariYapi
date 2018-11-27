package com.example.pc.retrofitopening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.retrofitopening.Adapter.AdapterBilgi;
import com.example.pc.retrofitopening.Models.Bilgiler;
import com.example.pc.retrofitopening.RestApi.ManagerServiceAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listBilgiler;
    List<Bilgiler> listResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        CallService();
    }

    private void Init() {
        listBilgiler = (ListView) findViewById(R.id.listBilgiler);
    }


    public void CallService() {
        try {
            listResponse = new ArrayList<>();
            Call<List<Bilgiler>> listCall = ManagerServiceAll.getOurInstance().bilgileriGetir();


            listCall.enqueue(new Callback<List<Bilgiler>>() {
                @Override
                public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                    BilgilerOnResponseSuccess(response);
                }

                @Override
                public void onFailure(Call<List<Bilgiler>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception ex) {

        }
    }

    private void BilgilerOnResponseSuccess(Response response) {
        try {
            if (response.isSuccessful()) {
                listResponse = (List<Bilgiler>) response.body();
                AdapterBilgi adapterBilgi = new AdapterBilgi(listResponse, getApplicationContext());
                listBilgiler.setAdapter(adapterBilgi);
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
