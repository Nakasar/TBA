package tech.orochi.testtba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Iperi on 07/06/2017.
 * Light Control panel.
 */

public class LightPanel extends Fragment {
    EditText bridgeIPText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.light_slider, container, false);
        bridgeIPText = (EditText) v.findViewById(R.id.bridgeBox);

        return inflater.inflate(R.layout.light_panel, container, false);
    }

    public String getBridgeIP() {
        return bridgeIPText.getText().toString();
    }
}
