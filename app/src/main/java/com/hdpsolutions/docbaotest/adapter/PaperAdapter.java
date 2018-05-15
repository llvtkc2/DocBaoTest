package com.hdpsolutions.docbaotest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hdpsolutions.docbaotest.R;
import com.hdpsolutions.docbaotest.dto.PaperDto;

import java.util.ArrayList;
import java.util.List;

public class PaperAdapter extends BaseAdapter {

    private static final String TAG = PaperAdapter.class.getName();
    private Context context;
    private List<PaperDto> data = new ArrayList<>();

    public PaperAdapter(Context context, ArrayList<PaperDto> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        Log.w(TAG, "getCount: " + data.size());
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        Log.w(TAG, "getItem: " + position);
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.w(TAG, "getItem: " + position);
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.w(TAG, "getView: " + position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_paper_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // get current item to be displayed
        PaperDto paperDto = (PaperDto) getItem(position);
        viewHolder.icon.setImageResource(paperDto.getIcon());
        viewHolder.title.setText(paperDto.getName());
        Log.w(TAG, "getView name: " + paperDto.getName());
        return convertView;
    }

    private class ViewHolder {
        ImageView icon;
        TextView title;

        public ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.layout_paper_item_icon);
            title = (TextView) view.findViewById(R.id.layout_paper_item_title);
        }
    }
}
