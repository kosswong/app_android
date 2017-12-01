package info.androidhive.loginandregistration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
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

public class UserDetailActivity extends Fragment {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;
    private Button btnPayment;

    private SQLiteHandler db;
    private SessionManager session;
    CollapsingToolbarLayout collapsingToolbarLayout;

    public static UserDetailActivity newInstance() {
        UserDetailActivity fragment = new UserDetailActivity();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_scrolling, container, false);

        txtName = (TextView) rootView.findViewById(R.id.name);
        txtEmail = (TextView) rootView.findViewById(R.id.email);
        btnLogout = (Button) rootView.findViewById(R.id.btnLogout);
        btnPayment = (Button) rootView.findViewById(R.id.btnPayment);

        // SqLite database handler
        db = new SQLiteHandler(getActivity());

        // session manager
        session = new SessionManager(getActivity().getApplicationContext());

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");
        collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("My account");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //showMovieList();
                //startActivity(new Intent(getActivity(), BasicPlayerActivity.class));
                logoutUser();
            }
        });


        // Logout button click event
        btnPayment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //showMovieList();
                //startActivity(new Intent(getActivity(), BasicPlayerActivity.class));
                doPayment();
            }
        });

        return rootView;
    }


    private void doPayment() {

        // Tag used to cancel the request
        String tag_string_req = "req_add_movie";

        StringRequest strReq = new StringRequest(Request.Method.POST, "http://10.0.2.2/app/user_pay.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {   // Received correct json file
                        TextView money = (TextView) getActivity().findViewById(R.id.money);
                        money.setText(jObj.getString("money"));
                        String message = jObj.getString("message");
                        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();

                    } else {
                        // Error occurred in registration. Get the error
                        String message = jObj.getString("error_msg");
                        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }


                    // Launch main activity
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to the url *****************************************

                HashMap<String, String> user = db.getUserDetails();
                String name = user.get("name");
                String email = user.get("email");
                String uid = user.get("uid");

                Map<String, String> params = new HashMap<String, String>();
                params.put("uid", uid);
                params.put("email", email);
                params.put("name", name);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }

    private void logoutUser() {
        session.setLogin(false);
        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(getActivity(), UserLoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}