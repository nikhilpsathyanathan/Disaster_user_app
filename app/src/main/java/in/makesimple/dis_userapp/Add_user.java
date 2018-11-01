package in.makesimple.dis_userapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Add_user extends AppCompatActivity {
    EditText name,ph,location,needs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        name=(EditText)findViewById(R.id.name);
        ph=(EditText)findViewById(R.id.ph);
        location=(EditText)findViewById(R.id.loc);
        needs=(EditText)findViewById(R.id.need) ;
        Button submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Data entered Successfully",Toast.LENGTH_SHORT).show();
                String sname=name.getText().toString().trim();
                String sloca=location.getText().toString().trim();
                String sph=ph.getText().toString().trim();
                String sneed=needs.getText().toString().trim();

                senddata("http://www.ohkwiz.com/api/help/", "{location:"+sloca+",name:"+sname+",phone:"+sph+",source:app}");
            }
        });
    }

    public void senddata(String URL, String json) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = URL;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("RES", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("RES", error.toString());
            }
        });
        queue.add(jsObjRequest);
    }
}
