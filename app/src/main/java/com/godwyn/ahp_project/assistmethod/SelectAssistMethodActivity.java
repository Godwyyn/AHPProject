package com.godwyn.ahp_project.assistmethod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ahpandroid.R;

public class SelectAssistMethodActivity extends AppCompatActivity {

    private SelectAssistMethodFragment mSelectAssistMethodFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_assist_method_act);

        if (mSelectAssistMethodFragment == null){
            mSelectAssistMethodFragment = SelectAssistMethodFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.dashboard_content_frame, mSelectAssistMethodFragment).commit();
        }
    }
}
