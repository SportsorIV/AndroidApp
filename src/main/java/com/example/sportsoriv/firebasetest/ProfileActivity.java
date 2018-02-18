package com.example.sportsoriv.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private TextView textUserEmail;
    private Button buttonLogout;
    private Button buttonData;
    private Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //getWindow().setBackgroundDrawableResource(R.drawable.wallpapperlogged);
       // firebaseAuth = FirebaseAuth.getInstance();
    //    if (firebaseAuth.getCurrentUser()== null){
     //       finish();
     //       startActivity(new Intent(this, LoginActivity.class));

     //   }
      //  FirebaseUser user = firebaseAuth.getCurrentUser();

        Intent intent = getIntent();
        String username = intent.getStringExtra("key");
        textUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textUserEmail.setText("Welcome " + username);
        buttonLogout = (Button) findViewById(R.id.buttonLogOut);
        buttonData = (Button) findViewById(R.id.buttonData);
        buttonSend = (Button) findViewById(R.id.buttonsend);


        buttonLogout.setOnClickListener(this);
        buttonData.setOnClickListener(this);
        buttonSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == buttonLogout){

           // firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if (view == buttonData){

            startActivity(new Intent(this,DataActivity.class));

        }
        if (view == buttonSend){
            Intent intent = getIntent();
            String username = intent.getStringExtra("key");
            Intent i = new Intent(getApplicationContext(),SendData.class);
            i.putExtra("key",username);
            //finish();
            startActivity(i);

        }

    }
}
