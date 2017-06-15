package tech.orochi.testtba;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kevin on 07/06/2017.
 */

public class LightSlider extends Fragment {
    String bridge = "192.168.1.18";
    String apiKey = "055644/9947";

    SeekBar lightVolume;
    Button bGreen;
    Button bRed;
    Button bBlue;
    Button bPurple;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.light_slider, container, false);

        lightVolume = (SeekBar) v.findViewById(R.id.lightVolume);
        lightVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bGreen = (Button) v.findViewById(R.id.bGreen);
        bGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable color = (ColorDrawable) v.getBackground();
                changeLight(1, color.getColor(), lightVolume.getProgress() * 254 / 100);
            }
        });

        bRed = (Button) v.findViewById(R.id.bRed);
        bRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable color = (ColorDrawable) v.getBackground();
                changeLight(1, color.getColor(), lightVolume.getProgress() * 254 / 100);
            }
        });

        bBlue = (Button) v.findViewById(R.id.bBlue);
        bBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable color = (ColorDrawable) v.getBackground();
                changeLight(1, color.getColor(), lightVolume.getProgress() * 254 / 100);
            }
        });

        bPurple = (Button) v.findViewById(R.id.bPurple);
        bPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable color = (ColorDrawable) v.getBackground();
                changeLight(1, color.getColor(), lightVolume.getProgress() * 254 / 100);
            }
        });

        return v;
    }

    public void changeLight(final int lightID, final int lcolor, final int lbrightness) {
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        String urlString = "http://" + bridge + "/api/" + apiKey + "/lights/" + lightID + "/state";
        JsonObjectRequest jsObjectRequest = new JsonObjectRequest(
                Request.Method.POST, urlString, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Response
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
            }
        }) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("on", "true");
                params.put("bri", "" + lbrightness);
                params.put("hue", "" + lcolor);

                return params;
            }
        };

        //Should access bridge IP, but can't... Need to refactor with the use of interfaces...

        Toast toast = Toast.makeText(this.getContext(), urlString, Toast.LENGTH_SHORT);
        toast.show();
        queue.add(jsObjectRequest);
    }
}
