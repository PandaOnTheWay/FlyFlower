package com.haha.flyflower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private Button mCheckButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckButton = (Button) findViewById(R.id.check_button);
        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText keywordText = (EditText)findViewById(R.id.editText);
                String keyword = keywordText.getText().toString();
                TextView result = (TextView)findViewById(R.id.textView);
                result.setMovementMethod(new ScrollingMovementMethod());
                String line,ans = "";
                boolean jud = false;
                try{
                    Scanner scan = new Scanner(getResources().getAssets().open("唐诗300"));
                    while(scan.hasNext()){
                        line = scan.nextLine();
                        if(line.indexOf(keyword)!=-1&&line.indexOf("：")==-1){
                            jud = true;
                            ans += line+"\n";
                        }
                    }
                    if(jud){
                        result.setText(ans);
                    }else{
                        result.setText("FOUND 404");
                    }
                }catch(IOException e){}

            }
        });



        }
}
