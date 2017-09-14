package com.houtrry.coordinatorlayoutsamples.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.houtrry.coordinatorlayoutsamples.R;

import java.util.List;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/9/11 14:09
 * @desc ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDesc $TODO$
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {

    private static final String TAG = CustomAdapter.class.getSimpleName();
    private List<String> nameList;

    public CustomAdapter(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomHolder holder, int position) {
        holder.textView.setText(nameList.get(position));
        Log.d(TAG, "onBindViewHolder: position: "+position);
    }

    @Override
    public int getItemCount() {
        return nameList == null?0:nameList.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public CustomHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
