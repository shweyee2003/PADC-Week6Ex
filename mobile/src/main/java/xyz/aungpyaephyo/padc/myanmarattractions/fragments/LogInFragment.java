package xyz.aungpyaephyo.padc.myanmarattractions.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.aungpyaephyo.padc.myanmarattractions.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LogInFragment extends Fragment {

    public LogInFragment() {
    }

    public static LogInFragment newInstance()
    {
        LogInFragment fragment=new LogInFragment();

        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}
