package abraham.com.myomdb.util;

import android.app.Application;

import abraham.com.myomdb.util.network.ServerRestClient;
import retrofit2.Retrofit;

/**
 * Created by Abraham on 24/01/2018.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private Retrofit retrofitInstance;

    public static synchronized MyApplication getInstance(){
        return instance;
    }

    public synchronized Retrofit getRetrofitInstance(){
        return retrofitInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        retrofitInstance =ServerRestClient.getClient("http://www.omdbapi.com/");

    }
}
