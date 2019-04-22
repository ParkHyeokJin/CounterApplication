package com.counter;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view = findViewById(R.id.textView);
        view.setTextSize(50);
        view.setPaintFlags(view.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        view.setGravity(Gravity.CENTER);
        view.setText("0");

        Button plusButton = findViewById(R.id.PlusButton);
        plusButton.setPaintFlags(plusButton.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        plusButton.setText("+");

        Button minusButton = findViewById(R.id.MinusButton);
        minusButton.setPaintFlags(minusButton.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        minusButton.setText("-");

        Button holdButton = findViewById(R.id.holdButton);
        holdButton.setPaintFlags(holdButton.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        holdButton.setText("HOLD");

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setPaintFlags(holdButton.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        resetButton.setText("RESET");
    }

    public void plusCount(View v){
        TextView view = findViewById(R.id.textView);
        int viewNum = Integer.parseInt(view.getText().toString());
        int viewInputNumber = ++viewNum;
        view.setText(String.valueOf(viewInputNumber));
    }

    public void minusCount(View v){
        TextView view = findViewById(R.id.textView);
        int viewNum = Integer.parseInt(view.getText().toString());
        int viewInputNumber = 0;
        if(viewNum > 0) {
            viewInputNumber = --viewNum;
        }
        view.setText(String.valueOf(viewInputNumber));
    }

    private boolean hold = false;
    public void holdButton(View v){
        Button plusButton = findViewById(R.id.PlusButton);
        Button minusButton = findViewById(R.id.MinusButton);
        Button holdButton = findViewById(R.id.holdButton);
        if(hold){
            hold = false;
            holdButton.setTextColor(Color.parseColor("#000000"));
            plusButton.setClickable(true);
            minusButton.setClickable(true);
            return;
        }
        hold = true;
        holdButton.setTextColor(Color.parseColor("#11FF11"));
        plusButton.setClickable(false);
        minusButton.setClickable(false);
    }

    public void numberReset(View v){
        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(MainActivity.this);
        alert_confirm.setMessage("카운터를 초기화 하시겠습니까?").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView view = findViewById(R.id.textView);
                view.setText("0");
            }
        }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //취소는 아무것도 없음.
            }
        });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }
}
