package tech.orochi.testtba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Iperi on 07/06/2017.
 * Fragment du menu de navigation.
 */

public class NavigationMenu extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_menu, container, false);
    }
}
