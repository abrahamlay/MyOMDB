package abraham.com.myomdb.util.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abraham on 24/01/2018.
 */

public class ServerRestClient {
    private static Retrofit retrofit=null;

    public static Retrofit getClient(String baseURL){

        if(retrofit==null){

            retrofit= new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
