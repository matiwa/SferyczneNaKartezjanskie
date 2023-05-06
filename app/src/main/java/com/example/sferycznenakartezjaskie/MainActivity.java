package com.example.sferycznenakartezjaskie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    EditText er,eHeLong,eHeLat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        er=findViewById(R.id.er);
        eHeLong=findViewById(R.id.eHeLong);
        eHeLat=findViewById(R.id.eHeLat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double r=0,HeLong=0,HeLat=0,x=0,y=0,z=0;
                tv.setText("");
                try{
                    r=Double.parseDouble(er.getText().toString());
                    HeLong=Double.parseDouble(eHeLong.getText().toString());
                    HeLat=Double.parseDouble(eHeLat.getText().toString());

                    x=r*Math.cos(HeLong/180*Math.PI)*Math.cos(HeLat/180*Math.PI);
                    y=r*Math.sin(HeLong/180*Math.PI)*Math.cos(HeLat/180*Math.PI);
                    z=r*Math.sin(HeLat/180*Math.PI);
                    tv.setText("Współrzędne sferyczne\r\n"+
                            "Odległość obiektu [m, km, Au] r="+r+"\r\n"+
                            "Długość sferyczna wyrażona w stopniach\r\nHeLong="+HeLong+"\r\n"+
                            "Szerokość sferyczna wyrażona w stopniach\r\nHeLat="+HeLat+"\r\n\r\n"+
                            "Współrzędne kartezjańskie (x,y,z)\r\nx="+x+"\r\ny="+y+"\r\nz="+z);
                }catch (Exception blad){
                    Toast.makeText(MainActivity.this,blad.getMessage(),
                            Toast.LENGTH_LONG).show();
                }finally {
                    er.setText("");
                    eHeLong.setText("");
                    eHeLat.setText("");
                }
            }
        });
    }
}