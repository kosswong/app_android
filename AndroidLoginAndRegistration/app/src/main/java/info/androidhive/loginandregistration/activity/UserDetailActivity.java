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

import java.util.HashMap;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.helper.SQLiteHandler;
import info.androidhive.loginandregistration.helper.SessionManager;

public class UserDetailActivity extends Fragment {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;

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

        // SqLite database handler
        db = new SQLiteHandler(getActivity());

        // session manager
        session = new SessionManager(getActivity().getApplicationContext());

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");
        collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("My acount");

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

        return rootView;
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