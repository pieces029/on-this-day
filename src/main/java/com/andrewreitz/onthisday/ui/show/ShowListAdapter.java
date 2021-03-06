package com.andrewreitz.onthisday.ui.show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andrewreitz.onthisday.R;
import com.andrewreitz.onthisday.data.api.reddit.model.Data;
import com.andrewreitz.velcro.bindableadapter.BindableAdapter;
import com.google.common.collect.Lists;
import java.util.List;

public class ShowListAdapter extends BindableAdapter<Data> {
  private List<Data> shows = Lists.newArrayList();

  public ShowListAdapter(Context context) {
    super(context);
  }

  public void add(List<Data> shows) {
    this.shows.addAll(shows);
    notifyDataSetChanged();
  }

  @Override public int getCount() {
    return shows.size();
  }

  @Override public Data getItem(int position) {
    return shows.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public View newView(LayoutInflater inflater, int position, ViewGroup container) {
    return inflater.inflate(R.layout.show_item_view, container, false);
  }

  @Override public void bindView(Data item, int position, View view) {
    ((ShowItemView) view).bindTo(item);
  }
}
