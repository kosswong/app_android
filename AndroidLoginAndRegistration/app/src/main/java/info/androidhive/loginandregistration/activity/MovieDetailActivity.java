package info.androidhive.loginandregistration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;

import info.androidhive.loginandregistration.R;

public class MovieDetailActivity extends AppCompatActivity {

    String json_string = "{\"error\":false,\"movie\":{\"pid\":\"1\",\"name\":\"Deadpool\",\"price\":\"1000\",\"description\":\"A fast-talking mercenary with a morbid sense of humor is subjected to a rogue experiment that leaves him with accelerated healing powers and a quest for revenge.\",\"class\":\"Action, Adventure, Comedy\",\"youtube\":\"https:\\/\\/www.youtube.com\\/watch?v=ONHBaC-pfsk\"},\"success\":1}";
    Intent intent = getIntent();
    int id = intent.getExtras().getInt("Id");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        TextView wid = (TextView) findViewById(R.id.wid);
        TextView name = (TextView) findViewById(R.id.name);
        TextView url = (TextView) findViewById(R.id.url);

        try {

            JSONObject movie=(new JSONObject(json_string)).getJSONObject("movie");

            wid.setText(Integer.toString(id));
            name.setText(movie.getString("name"));
            url.setText(movie.getString("youtube"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}