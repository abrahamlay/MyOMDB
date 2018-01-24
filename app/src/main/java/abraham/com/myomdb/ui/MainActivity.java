package abraham.com.myomdb.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import abraham.com.myomdb.R;
import abraham.com.myomdb.model.SearchRepository;
import abraham.com.myomdb.model.SearchResponse;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private MainPresenter presenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.json_response);

        presenter=new MainPresenter(this);

        loadData();
    }

    @Override
    public void loadData() {
        presenter.searchMovie("batman");
    }

    @Override
    public void onDataLoaded(String response) {
        textView.setText(response);
    }
}
