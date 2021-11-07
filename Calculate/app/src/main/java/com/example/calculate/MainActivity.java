package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    String curString;


    public void handleGrid(View view) {
        Button button = (Button) view;
        TextView result = findViewById(R.id.result);
        TextView current = findViewById(R.id.current);

        String curButton = button.getTag().toString();

        if(curButton.equals("xoa")) {
            curString = curString.substring(0,curString.length()-1);
            current.setText(curString);
        } else if(curButton.charAt(0) == '=') {
            int kq = 0;
//            int last = 0;
            List<String> list = Arrays.asList(curString.split(" "));
            kq += Integer.parseInt(list.get(0));
            for(int i = 1; i < list.size(); i++) {
                if(list.get(i).equals("+")){
//                    Log.i("kq", String.valueOf(kq));
//                    Log.i("i+1", list.get(i+1).replace(" ", ""));
                    kq += Integer.parseInt(list.get(i+1).replace(" ", ""));

                } else if (list.get(i).equals("-")) {
                    kq -= Integer.parseInt(list.get(i+1).replace(" ", ""));
//                    last = i + 1;
                } else if (list.get(i).equals("*")) {
                    kq *= Integer.parseInt(list.get(i+1).replace(" ", ""));
//                    last = i + 1;
                } else if (list.get(i).equals("/")) {
                    kq /= Integer.parseInt(list.get(i+1).replace(" ", ""));
//                    last = i + 1;
                }
            }
            result.setText(String.valueOf(kq));
        } else if (curButton.equals("ce")){
            curString = "";
            result.setText(String.valueOf(0));
            current.setText(curString);
        } else {
            curString += curButton + " ";
            current.setText(curString);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curString = "";
    }
}