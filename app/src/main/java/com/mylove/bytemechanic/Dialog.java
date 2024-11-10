package com.mylove.bytemechanic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dialog extends android.app.Dialog {
    private String percent;
    private Context context;
    private ImageView blurredBackground;
    EditText e1,e2;


    public Dialog(@NonNull Context context, int num) {
        super(context);
        this.percent = num + "%";
        this.context = context;
    }

    private TextView percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        setCancelable(true);


        percentage = findViewById(R.id.percent_text);
        blurredBackground = findViewById(R.id.blurredBackground);

        blurredBackground.setOnClickListener(v->{
            Dialog.this.dismiss();
        });

        percentage.setText(this.percent);

        getWindow().setDimAmount(0.7f);

    }
    void dismissed(EditText e1, EditText e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(listener);
        e1.setText("");
        e2.setText("");
        e1.requestFocus();
    }

    @Override
    public void setOnCancelListener(@Nullable OnCancelListener listener) {
        super.setOnCancelListener(listener);
        e1.setText("");
        e2.setText("");
        e1.requestFocus();
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {
        super.setCanceledOnTouchOutside(cancel);
        e1.setText("");
        e2.setText("");
        e1.requestFocus();
    }
}


