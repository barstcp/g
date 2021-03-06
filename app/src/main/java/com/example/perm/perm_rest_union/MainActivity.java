package com.example.perm.perm_rest_union;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.perm.perm_rest_union.activity.ActivityCallback;
import com.example.perm.perm_rest_union.view.fragments.ConfirmFragment;
import com.example.perm.perm_rest_union.view.fragments.LoginFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ActivityCallback {

    private  final static String TAG = "TAG";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();


        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) replaceFragment(new LoginFragment(), false);
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void startConfirm() {
        replaceFragment(ConfirmFragment.newInstance(), true);
    }

    @Override
    public void startWelcome() {
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
    }
}
