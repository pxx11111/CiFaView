package com.example.pxx.colorview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import Utils.TextUtils;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        InputStream inputStream = null;
        StringBuffer sb=null;
        String txt=null;
        try {
            inputStream = getAssets().open("input.txt");
            int size=inputStream.available();
            byte[]buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            txt=new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
         String keyWords[] = { "abstract", "boolean", "break", "byte",
                "case", "catch", "char", "class", "continue", "default", "do",

                "long", "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "super", "switch"
                };

        String operators[] = {"double", "else", "extends", "final", "finally", "float", "for",
                "if", "implements", "import", "instanceof", "int", "interface"}; // 运算符数组
        String separators[] = {"synchronized", "this", "throw", "throws", "transient", "try",
                "void", "volatile", "while", "strictfp","enum","goto","const","assert" };
        SpannableStringBuilder textString=null;
       ArrayList<String[]>arr=new ArrayList<>();
        arr.add(keyWords);
        arr.add(operators);
        arr.add(separators);
        int []arr1={Color.RED,Color.YELLOW,Color.BLACK};
        textString= TextUtils.highlight(txt,arr, arr1);



        tv.setText(textString);

    }









    }

