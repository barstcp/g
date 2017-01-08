package com.example.perm.perm_rest_union.view.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.perm.perm_rest_union.R;
import com.example.perm.perm_rest_union.activity.ActivityCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Ramil on 02.01.2017.
 */

public class ConfirmFragment extends Fragment {

    @Bind(R.id.btn_confirm)
    FancyButton button;

    ActivityCallback activityCallback;

    public static ConfirmFragment newInstance() {

        return new ConfirmFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            //TODO edit activity
            activityCallback = (ActivityCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement activityCallback");
        }
    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.confirm, viewGroup, false);

        ButterKnife.bind(this, view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCallback.startWelcome();
            }
        });
        return view;
    }
}
