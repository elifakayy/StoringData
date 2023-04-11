package com.elif.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =findViewById(R.id.editTextNumber);
        textView=findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.elif.storingdata", Context.MODE_PRIVATE);
        //kayıtlı bir şey yoksa:
        int storedAge = sharedPreferences.getInt("storedAge",0);

        if(storedAge==0)
            textView.setText("Your Age : ");

        else
            textView.setText("your Age : "+ storedAge);
    }

    public void save (View view)
    {
        //edit texte girilen değer var mı kontrolü
        if(!editText.getText().toString().matches(""))
        {
            int age=Integer.parseInt(editText.getText().toString());
            textView.setText("Your age : "+age);

            sharedPreferences.edit().putInt("storedAge", age).apply();


        }



    }

    public void delete(View view)
    {
        int storedage = sharedPreferences.getInt("storedAge",0);
        if (storedage!=0)
        {            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age : ");
        }


    }
}