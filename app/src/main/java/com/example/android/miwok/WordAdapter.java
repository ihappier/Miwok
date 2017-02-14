package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ihappier on 2016/12/23.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundId;


    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundId) {
        super(context, 0, words);
        mBackgroundId = backgroundId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //获取当前Word实例
        final Word currentWord = getItem(position);



        //定义miwok语的TEXTVIEW
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_list);
        miwokTextView.setText(currentWord.getMiwok());//设置miwork语单词

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.eng_list);
        englishTextView.setText(currentWord.getEnglish());

        ImageView  imageView = (ImageView) listItemView.findViewById(R.id.image_id);
        if (currentWord.hasImage()){
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageId());
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.words_list);
        int color = ContextCompat.getColor(getContext(),mBackgroundId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }

}
