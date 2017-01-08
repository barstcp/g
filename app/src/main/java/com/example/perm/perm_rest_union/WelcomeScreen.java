package com.example.perm.perm_rest_union;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

/**
 * Created by Ramil on 02.01.2017.
 */

public class WelcomeScreen extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setButtonBackFunction(true ? BUTTON_BACK_FUNCTION_SKIP : BUTTON_BACK_FUNCTION_BACK);
        //setButtonNextFunction(true ? BUTTON_NEXT_FUNCTION_NEXT_FINISH : BUTTON_NEXT_FUNCTION_NEXT);
        setButtonBackVisible(false);
        setButtonNextVisible(false);
        setButtonCtaVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);
        setButtonCtaLabel("Проспутить");

        addSlide(new SimpleSlide.Builder()
                .title("Добро пожаловать")
                .description("Мы рады вас приветствовать в сети ресторанов RESTUNION.")
                .image(R.drawable.button_background)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorAccent)
                .buttonCtaLabel("Продолжить")
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextSlide();
                    }
                })
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("Скидочная система")
                .description("...")
                .buttonCtaLabel(R.string.app_name)
                .background(R.color.colorAccent)
                .buttonCtaLabel("Начать")
                .canGoForward(false)
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       startApl();
                    }
                })
                .build());
    }

    private void startApl(){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}
