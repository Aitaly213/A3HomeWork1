package com.geektech.a3homework1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geektech.a3homework1.R;
import com.geektech.a3homework1.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {
    private RecyclerView recyclerView;
    private EmojiAdapter adapter;
    private EmojiGame game;
    private TextView textOver;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOver = findViewById(R.id.textOver);
        recyclerView = findViewById(R.id.rv_card);
        game = new EmojiGame();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new EmojiAdapter(game, this);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();

        if (game.getCards().isEmpty()) {
            textOver.setVisibility(View.VISIBLE);
            textOver.setText(R.string.gameOver);
        }
    }
}