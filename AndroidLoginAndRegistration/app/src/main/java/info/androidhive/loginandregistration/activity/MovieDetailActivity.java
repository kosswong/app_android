package info.androidhive.loginandregistration.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.app.AppController;
import info.androidhive.loginandregistration.helper.SQLiteHandler;
import info.androidhive.loginandregistration.helper.SessionManager;

public class MovieDetailActivity extends Activity {
    private ProgressDialog pDialog;
    private SessionManager session;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private SQLiteHandler db;
    private Button btnBuyMovie;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());

        Intent intent = getIntent();
        int id = intent.getExtras().getInt("Id");
        id++;

        String tag_string_req = "req_login";

        StringRequest strReq = new StringRequest(Method.POST, "http://10.0.2.2/app/movie_detail.php?vid="+id, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    TextView wid = (TextView) findViewById(R.id.wid);
                    TextView name = (TextView) findViewById(R.id.name);
                    TextView url = (TextView) findViewById(R.id.url);
                    TextView description = (TextView) findViewById(R.id.description);
                    TextView price = (TextView) findViewById(R.id.price);

                    // Check for error node in json
                    if (!error) {
                        JSONObject movie = jObj.getJSONObject("movie");
                        wid.setText(movie.getString("pid"));
                        name.setText(movie.getString("name"));
                        url.setText(movie.getString("youtube"));
                        description.setText(movie.getString("description"));
                        price.setText(movie.getString("price"));

                        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.moviebar_layout);
                        collapsingToolbarLayout.setTitle(movie.getString("name"));

                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

        btnBuyMovie = (Button) findViewById(R.id.buyMovie);

// Register Button Click event
        btnBuyMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                HashMap<String, String> user = db.getUserDetails();
                String name = user.get("name");
                String email = user.get("email");
                TextView wid = (TextView) findViewById(R.id.wid);
                String movie_id = wid.getText().toString();
                String uid = user.get("uid");

                String tag_string_req = "req_login";

                if (!name.isEmpty() && !email.isEmpty() && !movie_id.isEmpty() && !uid.isEmpty()) {
                    addMovieToCart(name, email, movie_id, uid);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "We cannot received your user record!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });



        button2 = (Button) findViewById(R.id.button2);

// Register Button Click event
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView url = (TextView) findViewById(R.id.url);
                String youtube_id = url.getText().toString();
                Intent intent = new Intent(MovieDetailActivity.this,
                        YouTubePlayerFragmentActivity.class);
                intent.putExtra("youtube_id", youtube_id);
                startActivity(intent);
                finish();
            }
        });

    }

    private void addMovieToCart(final String name, final String email, final String movie_id, final String uid) {
        // Tag used to cancel the request
        String tag_string_req = "req_add_movie";

        StringRequest strReq = new StringRequest(Method.POST, "http://10.0.2.2/app/movie_buy.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {   // Received correct json file
                        String message = jObj.getString("message");
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    } else {
                        // Error occurred in registration. Get the error
                        String message = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }

                    // Launch main activity
                    Intent intent = new Intent(MovieDetailActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to the url *****************************************
                Map<String, String> params = new HashMap<String, String>();
                params.put("uid", uid);
                params.put("email", email);
                params.put("name", name);
                params.put("movie_id", movie_id);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}