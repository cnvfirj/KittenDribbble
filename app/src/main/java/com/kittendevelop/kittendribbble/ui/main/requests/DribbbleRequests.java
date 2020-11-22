package com.kittendevelop.kittendribbble.ui.main.requests;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DribbbleRequests {

    @GET("oauth/token?")
    Call<DribbbleResponseToken> callToken(
            @Query("client_id") String id,
            @Query("client_secret") String secret,
            @Query("code")String code);

}
