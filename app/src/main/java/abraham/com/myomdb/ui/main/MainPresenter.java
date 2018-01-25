package abraham.com.myomdb.ui.main;

import abraham.com.myomdb.model.SearchRepository;
import abraham.com.myomdb.model.SearchResponse;
import abraham.com.myomdb.util.network.RemoteCallback;

/**
 * Created by Abraham on 24/01/2018.
 */

public class MainPresenter implements MainContract.MainAction {

    private final MainContract.MainView view;

    public MainPresenter(MainContract.MainView view) {
        this.view=view;
    }

    @Override
    public void searchMovie(String movieTitle) {
        SearchRepository.Search(movieTitle, new RemoteCallback.Load<SearchResponse>() {
            @Override
            public void onDataLoaded(SearchResponse data) {
                view.onDataLoaded(data);
            }

            @Override
            public void onFailed() {
                view.showError();
            }

            @Override
            public void onDataNotAvailable(String message) {
                view.showEmpty(message);
            }
        });
    }
}
