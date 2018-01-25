package abraham.com.myomdb.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import abraham.com.myomdb.R;
import abraham.com.myomdb.model.SearchItem;

/**
 * Created by Abraham on 25/01/2018.
 */

class SearchItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView tvTitle;
    private final OnItemClickListener listener;
    private SearchItem data;

    public SearchItemViewHolder(View itemView,OnItemClickListener listener) {
        super(itemView);
        this.listener=listener;
        tvTitle=itemView.findViewById(R.id.tv_movie_title);

    }

    public void bindData(SearchItem searchItem){
        data=searchItem;
        tvTitle.setText(searchItem.getTitle());
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClicked(v,data);
    }
}
