package info.androidhive.loginandregistration.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.app.AppController;
import info.androidhive.loginandregistration.helper.SQLiteHandler;
import info.androidhive.loginandregistration.helper.SessionManager;

public class UserCartActivity extends Fragment {
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    private AppCompatActivity mClass;

    public static UserCartActivity newInstance() {
        UserCartActivity fragment = new UserCartActivity();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.user_cart, container, false);

        // SQLite database handler
        db = new SQLiteHandler(getActivity().getApplicationContext());

        // Session manager
        session = new SessionManager(getActivity().getApplicationContext());

        String tag_string_req = "req_list";

        StringRequest strReq = new StringRequest(Request.Method.POST, "http://10.0.2.2/app/user_cart.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    ListView listView = (ListView) rootView.findViewById(R.id.cart_view);

                    List<String> items = new ArrayList<>();
                    List<String> price = new ArrayList<>();

                    JSONArray array= jObj.getJSONArray("products");

                    // Check for error node in json
                    if (!error) {

                        for(int i=0;i<array.length();i++)
                        {
                            JSONObject object= array.getJSONObject(i);
                            items.add(object.getString("name"));
                            price.add(object.getString("price"));
                        }

                        // the image
                        int[] Image = new int[items.size()];
                        for(int i=0;i<items.size();i++)
                        {
                            Image[i] = R.drawable.ic_theaters_black_24dp;
                        }

                        // old version
                        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);

                        // new version with image
                        // Each row in the list stores country name, currency and flag
                        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
                        for(int i=0;i<items.size();i++){
                            HashMap<String, String> hm = new HashMap<String,String>();
                            hm.put("image", Integer.toString(Image[i]) );
                            hm.put("name", items.get(i));
                            hm.put("price", price.get(i));
                            aList.add(hm);
                        }
                        // Keys used in Hashmap
                        String[] from = { "image", "name", "price"};
                        // Ids of views in listview_layout
                        int[] to = { R.id.cartItemImage,R.id.cartItemTextName, R.id.cartItemTextPrice};
                        // Instantiating an adapter to store each items
                        // R.layout.listview_layout defines the layout of each item
                        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.user_cart_row, from, to);

                        // Getting a reference to listview of main.xml layout file
                        listView = ( ListView ) getActivity().findViewById(R.id.cart_view);

                        if (listView != null) {
                            listView.setAdapter(adapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                public void onItemClick(AdapterView<?> parent, View view,
                                                        int position, long id) {
                                    // Movie detail view
                                    Intent myIntent = new Intent(getActivity(), MovieDetailActivity.class);
                                    myIntent.putExtra("Id", position);
                                    startActivity(myIntent);
                                }
                            });
                        }

                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getActivity(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
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
                // Posting parameters to login url

                HashMap<String, String> user = db.getUserDetails();
                String uid = user.get("uid");

                Map<String, String> params = new HashMap<String, String>();
                params.put("uid", uid);

                return params;
            }

        };


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

        return rootView;
    }
}