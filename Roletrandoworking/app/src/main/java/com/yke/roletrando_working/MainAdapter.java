package com.yke.roletrando_working;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

  ArrayList<String> mListaRestaurante;
  public MainAdapter(ArrayList<String> restList) {
      mListaRestaurante = restList;
  }

  @Override
  public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
      holder.mRestNames.setText(mListaRestaurante.get(position));
  }

  @Override
  public int getItemCount() {
    return mListaRestaurante.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView mRestNames;

    public ViewHolder(View itemView) {
      super(itemView);

      mRestNames = (TextView) itemView.findViewById(R.id.rest_names);
    }
  }
}
