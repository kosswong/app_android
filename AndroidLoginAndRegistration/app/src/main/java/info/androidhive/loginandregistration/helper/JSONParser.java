package info.androidhive.loginandregistration.helper;

        import java.io.BufferedInputStream;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;
        import java.net.HttpURLConnection;
        import java.util.List;


        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.util.Log;
        import android.util.Pair;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {

    }

    // function get json from url
    // by making HTTP POST or GET mehtod

    public JSONObject makeHttpRequest(String url, String method,
                                      String params) {
        InputStream in = null;
        // Making HTTP request
        try {

            // check for request method
            if (method == "POST") {
                // request method is POST
                // defaultHttpClient
                //		DefaultHttpClient httpClient = new DefaultHttpClient();
                //		HttpPost httpPost = new HttpPost(url);
                //		httpPost.setEntity(new UrlEncodedFormEntity(params));

                //		HttpResponse httpResponse = httpClient.execute(httpPost);
                //		HttpEntity httpEntity = httpResponse.getEntity();
                //		is = httpEntity.getContent();

            } else {
                if (method == "GET") {
                    // request method is GET
                    Log.i("in make http", "in httpmake");
                    //	DefaultHttpClient httpClient = new DefaultHttpClient();

                    //		String paramString = URLEncodedUtils.format(params, "utf-8");
                    Log.i("in make http url", url);
                    //		url += "?" + paramString;
                    if (params.equals("")) {
                    } else {
                        url = url + "?" + params;
                    }
                    Log.i("in make http params", params);

                    //	HttpGet httpGet = new HttpGet(url);

                    //	HttpResponse httpResponse = httpClient.execute(httpGet);
                    //	HttpEntity httpEntity = httpResponse.getEntity();


                    java.net.URL serverurl = new java.net.URL(url);
                    HttpURLConnection conn = (HttpURLConnection) serverurl.openConnection();
                    conn.setRequestMethod("GET");

// read the response.
                    Log.i("Response Code: ", Integer.toString(conn.getResponseCode()));
                    in = new BufferedInputStream(conn.getInputStream());


                    //	String response = IOUtils.toString(in, "UTF-8");

                    //	String is = IOUtils.toString(in, "UTF-8");
                    //	Log.i("response", response);
                    Log.i("in make http", "succesful http return");


					/*
					JSONArray array = new JSONArray(response);

					for(int i=0; i<array.length(); i++){
						JSONObject jsonObj  = array.getJSONObject(i);
						Log.i("json line",jsonObj.getString("name"));
						Log.i("json line2",jsonObj.getString("price"));

					}
                    */
                    //	is = httpEntity.getContent();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //	BufferedReader reader = new BufferedReader(new InputStreamReader(
            //			is, "iso-8859-1"), 8);
            //	Log.i("turning is", is);

			/* frank why????? */


            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    in, "UTF-8"));
            Log.i("after BufferRefere", reader.toString());

            StringBuilder sb = new StringBuilder();
            String line = null;
            line=reader.toString();
            Log.i("reader line",line);
            //		Log.i("reader line 2",reader.readLine());
            String nouse=reader.readLine();
            while ((line = reader.readLine()) != null) {
                Log.i("line readLine", line);
                Log.i("before sb while", line);
                sb.append(line + "\n");
                Log.i("appended line",line);

            }
            in.close();
            Log.i("before sb to string", "json");
            json = sb.toString();
            Log.i("json value confirmed", json);

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            //		jObj = new JSONObject(json);


            jObj = new JSONObject(json);

            Log.i("json object conf st", jObj.toString());
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }


}

