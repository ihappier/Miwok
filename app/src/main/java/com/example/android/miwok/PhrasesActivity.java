package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer(mp);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> words  = new ArrayList<>();
        words.add(new Word("lutti","one", R.raw.phrase_are_you_coming));
        words.add(new Word("otiiko","two", R.raw.phrase_come_here));
        words.add(new Word("tolookosu","three", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("oyyisa","four", R.raw.phrase_im_coming));
        words.add(new Word("massokaa","five", R.raw.phrase_im_feeling_good));
        words.add(new Word("temmokaa","six", R.raw.phrase_lets_go));
        words.add(new Word("kenekaku","seven", R.raw.phrase_my_name_is));
        words.add(new Word("kawinta","eight", R.raw.phrase_what_is_your_name));
        words.add(new Word("wo'e","nine", R.raw.phrase_where_are_you_going));
        words.add(new Word("na'aacha","ten", R.raw.phrase_yes_im_coming));


        final WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this,
                        itemsAdapter.getItem(position).getSoundId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer(mediaPlayer);
        Log.v("system","onStop");
    }
    private void releaseMediaPlayer(MediaPlayer mMediaPlayer) {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
//            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
