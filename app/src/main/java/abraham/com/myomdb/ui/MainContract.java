package abraham.com.myomdb.ui;

import abraham.com.myomdb.model.SearchResponse;

/**
 * Created by Abraham on 24/01/2018.
 */

public class MainContract {
    interface MainView{
        void loadData();
        void onDataLoaded(String response);
    }
    interface MainAction{
        void searchMovie(String movieTitle);
    }
}
