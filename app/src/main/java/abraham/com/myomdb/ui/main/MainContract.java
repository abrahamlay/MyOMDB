package abraham.com.myomdb.ui.main;

import abraham.com.myomdb.model.SearchResponse;

/**
 * Created by Abraham on 24/01/2018.
 */

public class MainContract {
    interface MainView{
        void loadData();
        void onDataLoaded(SearchResponse response);
        void showError();
        void showEmpty(String message);
    }
    interface MainAction{
        void searchMovie(String movieTitle);
    }
}
