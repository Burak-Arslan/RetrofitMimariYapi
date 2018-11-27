package com.example.pc.retrofitopening.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient() {

        RestApiClient restApiClient = new RestApiClient(BaseUrl.baseUrl);
        return restApiClient.restApi();
    }

}
