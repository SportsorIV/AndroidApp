package com.example.sportsoriv.firebasetest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;

    String URL_Login = "http://cir.di.ionio.gr/~p13stav/loginuserandroid.php";

   // String URL_Login = "http://192.168.64.2/loginuserandroid.php";

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setBackgroundDrawableResource(R.drawable.wallpapperfinal);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            //profile activity here
        }
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);
        progressDialog = new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
        editTextPassword.setOnClickListener(this);
        editTextEmail.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);


    }
private void userLogin(){
    final String email = editTextEmail.getText().toString().trim();
    final String password = editTextPassword.getText().toString().trim();



    if (TextUtils.isEmpty(email)) {
        Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        return;
    }
    if (TextUtils.isEmpty(password)) {
        Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
        return;

    }

    //check if passwords are same first



        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_Login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
                if(response.equals("Wrong Username or Password")){


                }else{

                    Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                    i.putExtra("key",email);
                    finish();
                    startActivity(i);

                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error+"", Toast.LENGTH_SHORT).show();

            }

        }) {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();


                params.put("USERNAME",email);
                params.put("PASSWORD",password);







                return params;


            }


        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);






}




    @Override
    public void onClick(View view) {
        if(view == buttonSignIn){
            userLogin();

        }
        if (view == textViewSignUp){
            finish();
            startActivity(new Intent(this, MainActivity.class));


        }
    }
}
