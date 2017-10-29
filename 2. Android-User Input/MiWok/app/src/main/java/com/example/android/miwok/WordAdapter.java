
package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 27-10-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId) {
        super(context, 0, words);
        this.colorResourceId=colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //LayoutInflater class is used to instantiate layout XML file into its corresponding View objects.
        //In other words, it takes as input an XML file and builds the View objects from it.

        View listItemView=convertView;
        if(listItemView == null) { //reuse recycled view
            listItemView=LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord=getItem(position);
        TextView miwokTranslation=(TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTranslation.setText(currentWord.getMiwokTranslation());


        TextView defaultTranslation=(TextView) listItemView.findViewById(R.id.original_text_view);
        defaultTranslation.setText(currentWord.getOriginalTranslation());
        ImageView chooseImage = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        if(currentWord.hasImage()) {
            chooseImage.setImageResource(currentWord.getImageResoucreId());
            chooseImage.setVisibility(View.VISIBLE);
        }
        else{
            chooseImage.setVisibility(View.GONE);
        }

        View textContainer= listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),colorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}