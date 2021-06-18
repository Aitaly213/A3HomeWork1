package com.geektech.a3homework1.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.geektech.a3homework1.data.Card;
import com.geektech.a3homework1.data.Game;

import java.util.List;

public class EmojiGame {
    private final Game<String> game;

    @RequiresApi(api = Build.VERSION_CODES.R)

    public EmojiGame() {
        List<String> content = List.of("\uD83D\uDE00", "\uD83E\uDD21", "\uD83D\uDE3A"
                , "\uD83D\uDC35", "\uD83E\uDD76", "\uD83E\uDDDB\u200D♂","\uD83E\uDDD9\u200D♂");
        game = new Game<>(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCard();
    }

}
