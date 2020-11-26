package com.kittendevelop.kittendribbble.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kittendevelop.kittendribbble.R;
import com.kittendevelop.kittendribbble.ui.main.requests.DribbbleRequests;
import com.kittendevelop.kittendribbble.ui.main.requests.DribbbleResponseToken;
import com.kittendevelop.kittendribbble.ui.register.DaggerComponentRegister;
import com.kittendevelop.kittendribbble.ui.register.RegisterDialog;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kittendevelop.kittendribbble.ui.help.Massages.MASSAGE;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private RegisterDialog mDialog;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }


    @Override
    public void onResume() {
        super.onResume();
        Uri uri = getActivity().getIntent().getData();
        if(uri!=null){
            mDialog.dismiss();
            extractData(uri);
        }else {
            if(mDialog==null) {
                mDialog = DaggerComponentRegister.create().dialog();
            }
            mDialog.show(getChildFragmentManager(), "REGISTER");
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void extractData(Uri uri){
        MASSAGE("uri "+uri.toString());
            requestToken(uri.getQueryParameter("code"));
    }

    private void requestToken(String code){
        MASSAGE("code "+code);
    }

    private void requestOKHTTPToken(String code){
        MASSAGE("code "+code);

        Observable.create(new ObservableOnSubscribe<Object>() {

            @Override
            public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<Object> emitter) throws Exception {
                RequestBody formBody = new FormBody.Builder()
                        .add("client_id", "8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0")
                        .add("client_secret", "4fc3c445569dbfe65998c470e88cc05fcd4872079ca1f2191eefec133895224e")
                        .add("code", code)
                        .build();

                Request.Builder builder = new Request.Builder()
                        .url("https://dribbble.com/oauth/token")
                        .post(formBody);
                Request request = builder.build();
                OkHttpClient client = new OkHttpClient();
                Call call = client.newCall(request);
                Response response = null;
                try {
                    response = call.execute();
                    ResponseBody body = response.body();
                    MASSAGE("body "+body.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                MASSAGE("fin");
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();


    }

    private void requestRetroToken(String code){
        MASSAGE("code "+code);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dribbble.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DribbbleRequests requests = retrofit.create(DribbbleRequests.class);
        retrofit2.Call<DribbbleResponseToken> callToken = requests.callToken(
                "8a4e6b1c8d3adca5d887b45a2147c48c11a3e4361ce5adef08964228413644a0",
                "4fc3c445569dbfe65998c470e88cc05fcd4872079ca1f2191eefec133895224e",
                code);

        callToken.enqueue(new Callback<DribbbleResponseToken>() {
            @Override
            public void onResponse(retrofit2.Call<DribbbleResponseToken> call, retrofit2.Response<DribbbleResponseToken> response) {
                MASSAGE("call token "+response.body().toString());
                MASSAGE("field token "+response.body().getAccessToken());
                MASSAGE("field scope "+response.body().getScope());
                MASSAGE("field type "+response.body().getTokenType());
            }

            @Override
            public void onFailure(retrofit2.Call<DribbbleResponseToken> call, Throwable t) {
                MASSAGE("error "+t.getMessage());
            }
        });

    }


}