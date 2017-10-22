package com.example.android.footballquizv2;

import android.content.Context;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.footballquizv2.R.id.radioGroup1;


public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{
    private List<listItem> listItems;
    private Context c;


    String x;
    String correct_answer="Bournemouth";
    private int score=0;

    public myAdapter(List<listItem> listItems, Context c) {
        this.listItems=listItems;
        this.c=c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if(viewType==R.layout.list_item){
            itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        }
        else {
            itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.button_item, parent, false);
        }
        return new ViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) { // binds data to viewHolder
        if(position==listItems.size()) {
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(c, "Button Clicked", Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            /*final int RB1_ID = 1000;//first radio button id
            final int RB2_ID = 1001;//second radio button id
            final int RB3_ID = 1002;//third radio button id
            final int RB4_ID = 1003;//third radio button id*/
            String x;
            listItem listItem=listItems.get(position);
            holder.textQuestion.setText(listItem.getQuestion());
            holder.textOption1.setText(listItem.getOption1());
            holder.textOption2.setText(listItem.getOption2());
            holder.textOption3.setText(listItem.getOption3());
            holder.textOption4.setText(listItem.getOption4());

            holder.radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // checkedId is the RadioButton selected
                    RadioButton rb=(RadioButton) group.findViewById(checkedId);
                    Toast.makeText(c, rb.getText(), Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });



            /*holder.radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i)
                {
                    RadioButton rb = (RadioButton)radioGroup.findViewById(i);
                    String txt = rb.getText().toString();
                    Toast.makeText(c,""+txt,Toast.LENGTH_SHORT).show();

                    if(txt=="Bournemouth") {
                        score += 10;
                        Toast.makeText(c,""+score,Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Toast.makeText(c,""+txt,Toast.LENGTH_SHORT).show();
                    }
                    notifyDataSetChanged();

                }
            });*/

        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position>listItems.size()-1) ? R.layout.button_item : R.layout.list_item;
    }
    @Override
    public int getItemCount() {
        return listItems.size()+1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textOption1,textOption2,textOption3,textOption4;
        public TextView textQuestion;
        public Button button;
        public RadioGroup radioGroup1;
        public ViewHolder(View itemView) {
            super(itemView);
            radioGroup1=(RadioGroup) itemView.findViewById(R.id.radioGroup1);
            textQuestion=(TextView) itemView.findViewById(R.id.textQuestion);
            textOption1=(TextView) itemView.findViewById(R.id.option1);
            textOption2=(TextView) itemView.findViewById(R.id.option2);
            textOption3=(TextView) itemView.findViewById(R.id.option3);
            textOption4=(TextView) itemView.findViewById(R.id.option4);
            button=(Button) itemView.findViewById(R.id.submitButton);

        }

    }
}
