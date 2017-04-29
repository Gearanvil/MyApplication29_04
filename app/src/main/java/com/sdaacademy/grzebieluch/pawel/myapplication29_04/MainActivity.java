package com.sdaacademy.grzebieluch.pawel.myapplication29_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.activity_main_list_view)
    ListView mainLV;

    @BindView(R.id.activity_main_edit_text)
    EditText mainET;

    @BindView(R.id.activity_main_refresh_button)
    Button refreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
