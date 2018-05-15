package com.hdpsolutions.docbaotest.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hdpsolutions.docbaotest.R;
import com.hdpsolutions.docbaotest.model.NewsItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private Activity context;
    private ArrayList<NewsItem> data = new ArrayList<>();

    public NewsAdapter(Activity context, ArrayList<NewsItem> data) {
        this.context = context;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.layout_news_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        NewsItem news = data.get(position);
        holder.textTitle.setText(news.getTitle());
        holder.textCatName.setText(news.getCategoryName());
        holder.textShort.setText(news.getShortNews());
        holder.textTime.setText(news.getTimeAgoString());
        Glide.with(context).load(news.getImageLink()).fitCenter().placeholder(R.drawable.ic_photos).crossFade().into(holder.image);

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.layout_news_item_image)
        ImageView image;
        @Bind(R.id.layout_news_item_textTitle)
        TextView textTitle;
        @Bind(R.id.layout_news_item_textShort)
        TextView textShort;
        @Bind(R.id.layout_news_item_textTime)
        TextView textTime;
        @Bind(R.id.layout_news_item_textCatName)
        TextView textCatName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
