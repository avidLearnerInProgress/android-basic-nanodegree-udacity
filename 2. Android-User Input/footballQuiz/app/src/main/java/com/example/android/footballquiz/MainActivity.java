package com.example.android.footballquiz;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String URL_DATA="https://api.myjson.com/bins/17sh53";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<listItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); //every item has fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems=new ArrayList<>();
        loadRecyclerViewData();

    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Load Data..");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            JSONArray array= jsonObject.getJSONArray("questions");
                            Toast.makeText(getApplicationContext(),"Hello"+array,Toast.LENGTH_SHORT).show();

                            for(int i=0;i<array.length();i++){
                                JSONObject o= array.getJSONObject(i);

                                JSONArray ja=o.getJSONArray("options");
                                Toast.makeText(getApplicationContext(),"Hello"+ja,Toast.LENGTH_SHORT).show();
                                //int length=ja.length();

                                ArrayList<String> optionNames=new ArrayList<String>();
                                for(int j=0;j<ja.length();j++){
                                    optionNames.add(ja.getString(j));
                                }
                                Toast.makeText(getApplicationContext(),"Hello"+optionNames,Toast.LENGTH_SHORT).show();


                                listItem item=new listItem(o.getString("id"),o.getString("question"),optionNames,o.getString("correct-answer"));
                                listItems.add(item);

                            }

                            adapter=new myAdapter(listItems,getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
