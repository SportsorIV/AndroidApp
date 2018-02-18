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

public class MainActivity extends AppCompatActivity implements View.OnClickListener   {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPassword2;

    private TextView textViewSignin;
    private int test = 0;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    String URL_CREATEUSER = "http://cir.di.ionio.gr/~p13stav/createuser.php";
    //String URL_CREATEUSER = "http://192.168.64.2/createuser.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.wallpapperfinal);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
           // startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            //profile activity here
        }

        progressDialog = new ProgressDialog(this);


        buttonRegister = (Button) findViewById(R.id.registerbutton);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPassword2 = (EditText) findViewById(R.id.editTextPassword2);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);


    }

    private void registerUser() {
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        String password2 = editTextPassword2.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;

        }

        //check if passwords are same first
        if (password.equals(password2)) {
            if (password.length() >= 8) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CREATEUSER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                        if (response.equals("0 Results")) {


                        } else {
                            Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                            i.putExtra("key", email);
                            finish();
                            startActivity(i);

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error + "", Toast.LENGTH_SHORT).show();

                    }

                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();


                        params.put("USERNAME", email);
                        params.put("PASSWORD", password);


                        return params;


                    }


                };
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);


            }else{
                Toast.makeText(MainActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();

            }

        }else{

            Toast.makeText(MainActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
        }
        test = 1 ;
    }
    @Override
    public void onClick(View view) {
        if (view == buttonRegister){

            registerUser();
            //finish();

        }


        if (view == textViewSignin){
            startActivity(new Intent(this, LoginActivity.class));

        }
    }
}
