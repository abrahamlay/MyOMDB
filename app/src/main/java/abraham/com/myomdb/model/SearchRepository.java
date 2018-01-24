package abraham.com.myomdb.model;

import abraham.com.myomdb.util.MyApplication;
import abraham.com.myomdb.util.network.RemoteCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abraham on 24/01/2018.
 */

public class SearchRepository {
    public static SearchAPI getSearchAPI(){
        return MyApplication.getInstance().getRetrofitInstance().create(SearchAPI.class);
    }

    public static void Search(String movieTitle, final RemoteCallback.Load<SearchResponse> callback){
        getSearchAPI().SearchMovie(movieTitle).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {

                if(response.isSuccessful()) {
                    callback.onDataLoaded(response.body());

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
//                    callback.onDataNotAvailable(response.message());
//                    callback.onDataNotAvailable(String.valueOf(statusCode));
                    callback.onDataNotAvailable(call.request().url().toString());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                    callback.onFailed();
            }
        });
    }
}
