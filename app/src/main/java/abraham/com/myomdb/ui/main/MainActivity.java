package abraham.com.myomdb.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import abraham.com.myomdb.R;
import abraham.com.myomdb.model.SearchItem;
import abraham.com.myomdb.model.SearchResponse;

public class MainActivity extends AppCompatActivity implements MainContract.MainView,
        OnItemClickListener{

    private MainPresenter presenter;
    private SearchView searchView;
    private RecyclerView rvSearchResult;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter=new MainPresenter(this);
        searchView=findViewById(R.id.sv_search_bar);
        rvSearchResult =findViewById(R.id.rv_search_result);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.searchMovie(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onDataLoaded(SearchResponse response) {
        if (response.getSearch()==null) return;
        adapter= new MainAdapter(response.getSearch(),this);
        rvSearchResult.setAdapter(adapter);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Connection Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClicked(View view, Object data) {
        SearchItem item=(SearchItem) data;
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
    }
}
