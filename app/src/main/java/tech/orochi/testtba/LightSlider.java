package tech.orochi.testtba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Kevin on 07/06/2017.
 */

public class LightSlider extends Fragment {
    TextView lightVolumeText;
    SeekBar lightVolume;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lightVolumeText = (TextView) getView().findViewById(R.id.lightVolumeText);
        lightVolume = (SeekBar) getView().findViewById(R.id.lightVolume);
        lightVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lightVolumeText.setText("p - " + seekBar.getId() + " : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return inflater.inflate(R.layout.light_slider, container, false);
    }
}
