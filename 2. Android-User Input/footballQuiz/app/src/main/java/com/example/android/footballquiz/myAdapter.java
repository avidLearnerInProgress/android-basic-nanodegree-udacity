package com.example.android.footballquiz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 20-10-2017.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    private List<listItem> listItems;
    private Context c;

    public myAdapter(List<listItem> listItems, Context c){
        this.listItems=listItems;
        this.c=c;
    }

    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myAdapter.ViewHolder holder, int position) {

        listItem lt=listItems.get(position);
       // holder.textId.setText(lt.getQuestionId());
        holder.textQuestion.setText(lt.getQuestion());
        //String [] optionsCombined=lt.getOptions().toArray(new String[4]);
        holder.textOptions.setText((CharSequence) lt.getOptions());
        //holder.textSolution.setText(lt.getSolution());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textOptions;
        public TextView textQuestion;
        public TextView textId;
        public TextView textSolution;

        public ViewHolder(View itemView){
            super(itemView);
            textQuestion=(TextView) itemView.findViewById(R.id.textQuestion);
            textOptions=(TextView) itemView.findViewById(R.id.textOptions);
            //textId=(TextView) itemView.findViewById(R.id.textID);
            //textSolution=(TextView) itemView.findViewById(R.id.textSolution);
        }
    }
}
