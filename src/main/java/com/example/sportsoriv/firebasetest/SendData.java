package com.example.sportsoriv.firebasetest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class SendData extends AppCompatActivity implements View.OnClickListener {



    private static final int REQUEST_LOCATION = 1;
 //   Button locationbutton;


    String lattitude,longitude;

    private String answer1;
    private String answer2;
    private String answer3;
    private EditText answer4;
    private EditText answer5;
    private EditText answer6;

    private TextView Question1;
    private TextView Question2;
    private TextView Question3;
    private TextView Question4;
    private TextView Question5;
    private TextView Question6;
    private TextView locationText;
    private TextView locationText2;
    LocationManager locationManager;
    LocationListener locationListener;


    ImageView imageView;
    Button selectimage;
    Button uploadImage;
  //  Button getlocation;
    Button answer1_1;
    Button answer1_2;
    Button answer1_3;
    Button answer1_4;

    Button answer2_1;
    Button answer2_2;
    Button answer2_3;
    Button answer2_4;

    Button answer3_1;
    Button answer3_2;
    Button answer3_3;
    Button answer3_4;



    Bitmap bitmap;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;


   String URL_DATA = " http://cir.di.ionio.gr/~p13stav/jsonencodeandroid.php";
    String urlUpload = "http://cir.di.ionio.gr/~p13stav/senddatatest.php";







    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_send_data);
        getWindow().setBackgroundDrawableResource(R.drawable.wallpapperlogged);



        Button button = (Button) findViewById(R.id.send);
        imageView = (ImageView) findViewById(R.id.imageView);
        selectimage = (Button) findViewById(R.id.selectimage);

        answer1_1 = (Button) findViewById(R.id.answer1_1);
        answer1_2 = (Button) findViewById(R.id.answer1_2);
        answer1_3 = (Button) findViewById(R.id.answer1_3);
        answer1_4 = (Button) findViewById(R.id.answer1_4);



        answer2_1 = (Button) findViewById(R.id.answer2_1);
        answer2_2 = (Button) findViewById(R.id.answer2_2);
        answer2_3 = (Button) findViewById(R.id.answer2_3);
        answer2_4 = (Button) findViewById(R.id.answer2_4);

        answer3_1 = (Button) findViewById(R.id.answer3_1);
        answer3_2 = (Button) findViewById(R.id.answer3_2);
        answer3_3 = (Button) findViewById(R.id.answer3_3);
        answer3_4 = (Button) findViewById(R.id.answer3_4);



        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();

            }
        });

        locationText = (TextView) findViewById(R.id.locationtextView);
        locationText.setOnClickListener(this);
        locationText2 = (TextView) findViewById(R.id.locationtextView2);
        locationText2.setOnClickListener(this);
       // locationbutton = (Button)findViewById(R.id.button_location);
      //  locationbutton.setOnClickListener(this);





        answer1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer1_1.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer1_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1= answer1_1.getText().toString().trim();
            }
        });
        answer1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer1_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_2.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer1_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1= answer1_2.getText().toString().trim();

            }
        });
        answer1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer1_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_3.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer1_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1= answer1_3.getText().toString().trim();

            }
        });

        answer1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer1_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer1_4.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer1= answer1_4.getText().toString().trim();

            }
        });

        // END OF QUESTION 1

        //QUESTION 2

        answer2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer2_1.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer2_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2= answer2_1.getText().toString().trim();
            }
        });
        answer2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer2_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_2.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer2_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2= answer2_2.getText().toString().trim();

            }
        });
        answer2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer2_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_3.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer2_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2= answer2_3.getText().toString().trim();

            }
        });

        answer2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer2_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer2_4.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer2= answer2_4.getText().toString().trim();

            }
        });

        // END QUESTION 2

        // QUESTION 3
        answer3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer3_1.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer3_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3= answer3_1.getText().toString().trim();
            }
        });
        answer3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer3_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_2.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer3_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3= answer3_2.getText().toString().trim();

            }
        });
        answer3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer3_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_3.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer3_4.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3= answer3_3.getText().toString().trim();

            }
        });

        answer3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer3_1.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_2.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_3.setBackground(getResources().getDrawable(R.drawable.register_button));
                answer3_4.setBackground(getResources().getDrawable(R.drawable.button_pressed));
                answer3= answer3_4.getText().toString().trim();

            }
        });


        //END QUESTION 3

        //FIELDS

        answer4 = (EditText) findViewById(R.id.answer4);
        answer5 = (EditText) findViewById(R.id.answer5);
        answer6 = (EditText) findViewById(R.id.answer6);
        answer4.setOnClickListener(this);
        answer5.setOnClickListener(this);
        answer6.setOnClickListener(this);

        //END FIELDS
        Question1 = (TextView) findViewById(R.id.question1);
        Question2 = (TextView) findViewById(R.id.Question2);
        Question3 = (TextView) findViewById(R.id.Question3);
        Question4 = (TextView) findViewById(R.id.Question4);
        Question5 = (TextView) findViewById(R.id.Question5);
        Question6 = (TextView) findViewById(R.id.Question6);



        Question1.setOnClickListener(this);
        Question2.setOnClickListener(this);
        Question3.setOnClickListener(this);
        Question4.setOnClickListener(this);
        Question5.setOnClickListener(this);
        Question6.setOnClickListener(this);

        locationText.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            getLocation();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertSV();
            }
        });

        /*
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    buildAlertMessageNoGps();

                } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    getLocation();
                }
            }
        });
        */

        getData();

    getLocation();
    }




    //GALLERY SELECT IMAGE
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int reusltCode, Intent data) {
        super.onActivityResult(requestCode, reusltCode, data);
        if (reusltCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);

        }
    }
    //SEND THE POST
    private void InsertSV() {
        final ProgressDialog progressDialog = new ProgressDialog(SendData.this);
        progressDialog.setTitle("Uploading");
        progressDialog.setMessage("Please wait");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlUpload, new Response.Listener<String>() {

           // final Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Toast.makeText(getApplication(),"Upload Complete",Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(SendData.this, error+"", Toast.LENGTH_SHORT).show();

            }

        }) {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<String, String>();

                final Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                byte[] imageBytes = outputStream.toByteArray();
                String encodedImage = Base64.encodeToString(imageBytes,Base64.DEFAULT);




                String answer4final = answer4.getText().toString().trim();
                String answer5final = answer5.getText().toString().trim();
                String answer6final = answer6.getText().toString().trim();
                String latitude = locationText.getText().toString().trim();
                String longitude = locationText2.getText().toString().trim();
                Intent intent = getIntent();
                String username = intent.getStringExtra("key");

                params.put("image",encodedImage);
                params.put("USERNAME",username);
                params.put("ANSWER1",answer1);
                params.put("ANSWER2",answer2);
                params.put("ANSWER3",answer3);
                params.put("ANSWER4",answer4final);
                params.put("ANSWER5",answer5final);
                params.put("ANSWER6",answer6final);
                params.put("LATITUDE",latitude);
                params.put("LONGITUDE",longitude);





                return params;


                }


             };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void getData(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {




                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("results");

                    for (int i=0; i<array.length(); i++){
                        JSONObject o = array.getJSONObject(i);

                        Question1.setText(o.getString("Question1"));
                        Question2.setText(o.getString("Question2"));
                        Question3.setText(o.getString("Question3"));
                        Question4.setText(o.getString("Question4"));
                        Question5.setText(o.getString("Question5"));
                        Question6.setText(o.getString("Question6"));

                        answer1_1.setText(o.getString("Button1_1"));
                        answer1_2.setText(o.getString("Button1_2"));
                        answer1_3.setText(o.getString("Button1_3"));
                        answer1_4.setText(o.getString("Button1_4"));

                        answer2_1.setText(o.getString("Button2_1"));
                        answer2_2.setText(o.getString("Button2_2"));
                        answer2_3.setText(o.getString("Button2_3"));
                        answer2_4.setText(o.getString("Button2_4"));

                        answer3_1.setText(o.getString("Button3_1"));
                        answer3_2.setText(o.getString("Button3_2"));
                        answer3_3.setText(o.getString("Button3_3"));
                        answer3_4.setText(o.getString("Button3_4"));



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            Location location2 = locationManager.getLastKnownLocation(LocationManager. PASSIVE_PROVIDER);

            if (location != null) {
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                locationText.setText(lattitude);
                locationText2.setText(longitude);

            } else  if (location1 != null) {
                double latti = location1.getLatitude();
                double longi = location1.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                locationText.setText(lattitude);
                locationText2.setText(longitude);


            } else  if (location2 != null) {
                double latti = location2.getLatitude();
                double longi = location2.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                locationText.setText(lattitude);
                locationText2.setText(longitude);

            }else{

                Toast.makeText(this,"Unable to Trace your location",Toast.LENGTH_SHORT).show();

            }
        }
    }

    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your GPS Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }



    @Override
    public void onClick(View view) {



    }


}
