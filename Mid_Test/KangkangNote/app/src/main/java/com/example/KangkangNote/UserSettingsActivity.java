package com.example.KangkangNote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.widget.Toolbar;

import com.example.biji.R;

public class UserSettingsActivity extends BaseActivity {

    private Switch nightMode;
    private SharedPreferences sharedPreferences;
    private Boolean night_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference_layout);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Intent intent = getIntent();
        /*
        if(intent.getExtras() != null) night_change = intent.getBooleanExtra("night_change", false);
        else night_change = false;

         */
        initView();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(isNightMode()) myToolbar.setNavigationIcon(getDrawable(R.drawable.ic_settings_white_24dp));
        else myToolbar.setNavigationIcon(getDrawable(R.drawable.ic_settings_black_24dp));
    }

    public void initView(){
        nightMode = findViewById(R.id.nightMode);
        nightMode.setChecked(sharedPreferences.getBoolean("nightMode", false));
        nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setNightModePref(isChecked);
                setSelfNightMode();

            }
        });
    }

    private void setNightModePref(boolean night){
        //通过nightMode switch修改pref中的nightMode
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("nightMode", night);
        editor.commit();
    }

    private void setSelfNightMode(){
        //重新赋值并重启本activity

        super.setNightMode();
        Intent intent = new Intent(this, UserSettingsActivity.class);
        //intent.putExtra("night_change", !night_change); //重启一次，正负颠倒。最终为正值时重启MainActivity。

        startActivity(intent);
        finish();
    }
}
