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
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private Logger logger = Logger.getLogger(MainActivity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view = findViewById(R.id.textView);
        view.setTextSize(50);
        view.setPaintFlags(view.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        view.setGravity(Gravity.RIGHT);
        view.setText("0");

        TextView firstNumText = findViewById(R.id.firstNumber);
        TextView SecNumText = findViewById(R.id.SecNumber);
        TextView ThdNumText = findViewById(R.id.ThdNumber);

        firstNumText.setTextSize(80);
        SecNumText.setTextSize(80);
        ThdNumText.setTextSize(80);

        firstNumText.setText("0");
        firstNumText.setGravity(Gravity.CENTER);
        SecNumText.setText("0");
        SecNumText.setGravity(Gravity.CENTER);
        ThdNumText.setText("0");
        ThdNumText.setGravity(Gravity.CENTER);
    }

    public void plusCount(View v){
        TextView firstNumText = findViewById(R.id.firstNumber);
        TextView SecNumText = findViewById(R.id.SecNumber);
        TextView ThdNumText = findViewById(R.id.ThdNumber);

        StringBuilder sb = new StringBuilder()
                .append(ThdNumText.getText().toString())
                .append(SecNumText.getText().toString())
                .append(firstNumText.getText().toString());

        int number = Integer.parseInt(sb.toString());
        if(number == 999){
            return;
        }
        String[] resultStr = spaceToZero(++number, "0", 3).split("");
        ThdNumText.setText(resultStr[1]);
        SecNumText.setText(resultStr[2]);
        firstNumText.setText(resultStr[3]);
        setTenNumberToTextView(resultStr[3], resultStr[2], resultStr[1]);
    }

    public String spaceToZero(int number, String spaceItem, int len){
        String strNum = String.valueOf(number);
        StringBuffer sb = new StringBuffer(strNum);
        for(int i = 0; i < len - strNum.length(); i++){
            sb.insert(0, spaceItem);
        }
        return sb.toString();
    }

    public void setTenNumberToTextView(String firstNumber, String secNumber, String thdNumber){
        StringBuilder sb = new StringBuilder()
                .append(thdNumber)
                .append(secNumber)
                .append(firstNumber);

        int resultNumber = Integer.parseInt(sb.toString());
        if(resultNumber % 10 != 0) {
            return;
        }

        TextView view = findViewById(R.id.textView);
        view.setText(String.valueOf(resultNumber));
    }
    public void minusCount(View v){
        TextView firstNumText = findViewById(R.id.firstNumber);
        TextView SecNumText = findViewById(R.id.SecNumber);
        TextView ThdNumText = findViewById(R.id.ThdNumber);

        StringBuilder sb = new StringBuilder()
                .append(ThdNumText.getText().toString())
                .append(SecNumText.getText().toString())
                .append(firstNumText.getText().toString());

        int number = Integer.parseInt(sb.toString());
        if(number == 0){
            return;
        }

        String[] resultStr = spaceToZero(--number, "0", 3).split("");
        ThdNumText.setText(resultStr[1]);
        SecNumText.setText(resultStr[2]);
        firstNumText.setText(resultStr[3]);
        setTenNumberToTextView(resultStr[3], resultStr[2], resultStr[1]);
    }

    private boolean hold = false;
    public void holdButton(View v){
        ImageButton plusButton = findViewById(R.id.PlusButton);
        ImageButton minusButton = findViewById(R.id.MinusButton);
        Button holdButton = findViewById(R.id.holdButton);
        if(hold){
            hold = false;
            holdButton.setTextColor(Color.parseColor("#000000"));
            plusButton.setClickable(true);
            minusButton.setClickable(true);
            return;
        }
        hold = true;
        holdButton.setTextColor(Color.parseColor("#00FF00"));
        plusButton.setClickable(false);
        minusButton.setClickable(false);
    }

    public void numberReset(View v){
        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(MainActivity.this);
        alert_confirm.setMessage("Reset this counter?").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView view = findViewById(R.id.textView);
                view.setText("0");

                TextView firstNumText = findViewById(R.id.firstNumber);
                TextView SecNumText = findViewById(R.id.SecNumber);
                TextView ThdNumText = findViewById(R.id.ThdNumber);

                firstNumText.setText("0");
                SecNumText.setText("0");
                ThdNumText.setText("0");

            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //취소는 아무것도 없음.
            }
        });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }
}
