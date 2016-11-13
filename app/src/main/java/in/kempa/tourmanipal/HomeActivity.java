package in.kempa.tourmanipal;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import in.kempa.tourmanipal.adapters.PlaceAdapter;
import in.kempa.tourmanipal.places.Places;

public class HomeActivity extends AppCompatActivity {
    RecyclerView placeRecycler;
    private ArrayList<Places> placeList = new ArrayList<>();
    private PlaceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        placeRecycler = (RecyclerView) findViewById(R.id.placeList);

        mAdapter = new PlaceAdapter(placeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(placeRecycler.getContext());
        placeRecycler.setLayoutManager(mLayoutManager);

        placeRecycler.setAdapter(mAdapter);


        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, TourManipal.getWebsite(), null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               new MyTask().execute(response);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingelton.getInstance(this.getApplicationContext()).addToRequestQueue(request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }
        else if (id==R.id.action_add_place){
            Intent intent=new Intent(this.getApplicationContext(),AddPlaceActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    class MyTask extends AsyncTask<JSONObject, JSONObject, Void> {
        @Override
        protected Void doInBackground(JSONObject... params) {
            try {
                JSONArray jsonarray = params[0].getJSONArray("nearPlaces");
                for (int i = 0; i < jsonarray.length(); i++) {
                    publishProgress(jsonarray.getJSONObject(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(JSONObject... values) {
            super.onProgressUpdate(values);
            Places places = new Places();
            try {
                places.setName((String) values[0].get("name"));
                places.setDescription((String) values[0].get("description"));
                places.setRatings(Float.valueOf(values[0].get("ratings").toString()));
                placeList.add(places);
                mAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            mAdapter.notifyDataSetChanged();
        }
    }
}
