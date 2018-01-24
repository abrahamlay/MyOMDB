package abraham.com.myomdb.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abraham on 24/01/2018.
 */

public interface SearchAPI {
    @GET("?apikey=283cab5e&type=movie&")
    Call<SearchResponse> SearchMovie(@Query("s") String searchQuery);
}
