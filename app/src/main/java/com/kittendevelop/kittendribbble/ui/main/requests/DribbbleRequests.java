package com.kittendevelop.kittendribbble.ui.main.requests;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DribbbleRequests {

    @POST("oauth/token?")
    Call<DribbbleResponseToken> callToken(
            @Query("client_id") String id,
            @Query("client_secret") String secret,
            @Query("code")String code);

}
