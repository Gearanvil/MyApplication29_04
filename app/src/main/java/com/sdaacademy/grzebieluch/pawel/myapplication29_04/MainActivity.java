package com.sdaacademy.grzebieluch.pawel.myapplication29_04;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.sdaacademy.grzebieluch.pawel.myapplication29_04.adapter.TaskArrayAdapter;
import com.sdaacademy.grzebieluch.pawel.myapplication29_04.model.Task;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.activity_main_list_view)
    ListView mainLV;

    @BindView(R.id.activity_main_edit_text)
    EditText mainET;

    @BindView(R.id.activity_main_refresh_button)
    Button refreshBtn;
    private ArrayAdapter adapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        taskList = new ArrayList<>();
        adapter = new TaskArrayAdapter(this, taskList);
        mainLV.setAdapter(adapter);
        new MyAsyncTask().execute();

    }

    private class MyAsyncTask extends AsyncTask<Task, Void, Task[]> {


        String readStream;
        Task[] task;

        @Override
        protected Task[] doInBackground(Task... params) {

// The connection URL
            String url = "http://shrouded-fjord-81597.herokuapp.com/api/task/all/4";

// Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
            task= restTemplate.getForObject(url, Task[].class);


            return task;
        }

        protected void onPostExecute(Task[] task) {


            adapter.notifyDataSetChanged();
        }

    }


    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
