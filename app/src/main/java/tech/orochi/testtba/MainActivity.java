package tech.orochi.testtba;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HomePanel homePanel;
    private LightPanel lightPanel;
    private SoundPanel soundPanel;
    private MusicPanel musicPanel;
    private ImagePanel imagePanel;
    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // On initialise nos fragments,
        homePanel = new HomePanel();
        lightPanel = new LightPanel();
        soundPanel = new SoundPanel();
        musicPanel = new MusicPanel();
        imagePanel = new ImagePanel();

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            activeFragment = homePanel;

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            activeFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, activeFragment).commit();

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.music_panel_button:
                switchPanel(musicPanel);
                return true;

            case R.id.sound_panel_button:
                switchPanel(soundPanel);
                return true;

            case R.id.image_panel_button:
                switchPanel(imagePanel);
                return true;

            case R.id.light_panel_button:
                switchPanel(lightPanel);
                return true;

            case R.id.home_panel_button:
                switchPanel(homePanel);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void switchPanel(android.support.v4.app.Fragment newFragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(activeFragment.getId(), newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public HomePanel getHomePanel(){
        return homePanel;
    }

    public ImagePanel getImagePanel(){
        return imagePanel;
    }

    public LightPanel getLightPanel(){
        return lightPanel;
    }

    public MusicPanel getMusicPanel(){
        return musicPanel;
    }

    public SoundPanel getSoundPanel(){
        return soundPanel;
    }

    public Fragment getActiveFragment(){
        return activeFragment;
    }
}
