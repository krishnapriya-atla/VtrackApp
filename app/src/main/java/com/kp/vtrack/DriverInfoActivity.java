package com.kp.vtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class DriverInfoActivity extends AppCompatActivity {
    private Spinner Sitem;
    String[] names={"VITAP","VIT"};
    LinearLayout l;
    Button signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);
        Sitem=findViewById(R.id.Sitem2);
        Sitem.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,names));
        l=findViewById(R.id.l5);
        signout=findViewById(R.id.btn_signOut);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(DriverInfoActivity.this, "LOGED out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DriverInfoActivity.this,LoginPageActivity.class));
                finish();
            }
        });
        /*Intent intent = getIntent();
        String rNO=getIntent().getStringExtra("rNO");
        String stops=getIntent().getStringExtra("stops");
        String BusNames=getIntent().getStringExtra("BusNames");
        Double rating = (Double) getIntent().getStringExtra("rating");;
        String people=getIntent().getStringExtra("people");
        TextView RouteNo = findViewById(R.id.RouteNo);
        TextView BusNo = findViewById(R.id.BusNo);
        TextView Stops = findViewById(R.id.Stops);
        TextView People = findViewById(R.id.People);
        TextView Rating = findViewById(R.id.Rating);
        RouteNo.setText(rNO);
        BusNo.setText(BusNames);
        Stops.setText(stops);
        People.setText(people);
        Rating.setText(String.valueOf(rating);
        RelativeLayout r=findViewById(R.id.r1);
        if(rating<3.0){
            r.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else if(rating<4.0 && rating>=3.0){
            r.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else{
            r.setBackgroundColor(getResources().getColor(R.color.green));
        }*/
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DriverInfoActivity.this,HomePage.class);
                startActivity(intent);
            }
        });
        /*Sitem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });*/
    }
}