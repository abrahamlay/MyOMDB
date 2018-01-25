package abraham.com.myomdb.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import abraham.com.myomdb.R;
import abraham.com.myomdb.model.SearchItem;

/**
 * Created by Abraham on 25/01/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {


    private List<SearchItem> responseList= new ArrayList<>();
    private final OnItemClickListener listener;

    public MainAdapter(List<SearchItem> itemList, OnItemClickListener listener) {
            this.responseList=itemList;
            this.listener=listener;
    }

    @Override
    public SearchItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_response,parent,false);

        return new SearchItemViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(SearchItemViewHolder holder, int position) {
        holder.bindData(responseList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
