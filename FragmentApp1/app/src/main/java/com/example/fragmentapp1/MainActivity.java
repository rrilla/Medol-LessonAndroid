package com.example.fragmentapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.container) != null) {
            if (savedInstanceState != null) {  //현재 액티비티의 상태
                return;
            }
            AFragment fragment = new AFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container, fragment);
            ft.commit();
           //getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
            //메소드 체인
        }
    }

    public void selectFragment(View v){
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.buttonA: fragment = new AFragment();break;
            case R.id.buttonB: fragment = new BFragment();break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}