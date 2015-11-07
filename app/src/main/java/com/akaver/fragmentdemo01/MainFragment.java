package com.akaver.fragmentdemo01;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by akaver on 07.11.2015.
 */
public class MainFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return view;
    }

    public interface OnItemSelectedListener {
        public void onFragmentItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MainFragment.OnItemSelectedListener");
        }
    }

    // triggers update of the details fragment
    public void updateDetail() {
        // create data
        String newTime = DateFormat.getDateTimeInstance().format(new Date());
        // send data to activity
        listener.onFragmentItemSelected(newTime);
    }
}
