package io.zla.reactions.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

import io.zla.reactions.sample.R;
import io.zla.reactions.ReactionPopup;
import io.zla.reactions.ReactionsConfig;
import io.zla.reactions.ReactionsConfigBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup(R.id.facebook_btn, new ReactionsConfigBuilder(this)
                .setReactions(new int[]{
                        R.drawable.ic_fb_like,
                        R.drawable.ic_fb_love,
                        R.drawable.ic_fb_laugh,
                        R.drawable.ic_fb_wow,
                        R.drawable.ic_fb_sad,
                        R.drawable.ic_fb_angry
                })
                .build());

        int margin = getResources().getDimensionPixelSize(R.dimen.crypto_item_margin);
        setup(R.id.crypto_btn, new ReactionsConfigBuilder(this)
                .setReactions(new int[]{
                        R.drawable.ic_crypto_btc,
                        R.drawable.ic_crypto_ltc,
                        R.drawable.ic_crypto_dash,
                        R.drawable.ic_crypto_xrp,
                        R.drawable.ic_crypto_xmr,
                        R.drawable.ic_crypto_usdt,
                        R.drawable.ic_crypto_doge,
                        R.drawable.ic_crypto_steem,
                        R.drawable.ic_crypto_kmd,
                        R.drawable.ic_crypto_zec
                })
                .setPopupColor(Color.LTGRAY)
                .setReactionSize(getResources().getDimensionPixelSize(R.dimen.crypto_item_size))
                .setHorizontalReactionMargin(margin)
                .setVerticalReactionMargin(margin / 2)
                .build());
    }

    private void setup(@IdRes int btnId, ReactionsConfig config) {
        ReactionPopup reactionPopup = new ReactionPopup(this, config);
        reactionPopup.setReactionSelectedListener((reaction, position) -> {
            Toast toast = Toast.makeText(MainActivity.this,
                    reaction + " selected at position=" + position,
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 300);
            toast.show();
        });

        findViewById(btnId).setOnTouchListener(reactionPopup);
    }
}