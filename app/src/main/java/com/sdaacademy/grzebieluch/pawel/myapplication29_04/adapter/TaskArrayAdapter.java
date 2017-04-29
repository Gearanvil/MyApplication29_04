package com.sdaacademy.grzebieluch.pawel.myapplication29_04.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sdaacademy.grzebieluch.pawel.myapplication29_04.R;
import com.sdaacademy.grzebieluch.pawel.myapplication29_04.model.Task;

import java.util.List;

/**
 * Created by RENT on 2017-04-29.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {
    public TaskArrayAdapter(Context context, List<Task> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);
        if (convertView == null) convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_row, parent, false);

        TextView rowNumber = (TextView) convertView.findViewById(R.id.single_row_item_number);
        TextView rowText = (TextView) convertView.findViewById(R.id.single_row_item_text);
        CheckBox checkerBox = (CheckBox) convertView.findViewById(R.id.single_row_item_check_box);

        rowNumber.setText(position+1+".");
        rowText.setText(task.getValue());
        if(task.isCompleted()) checkerBox.isChecked();



        return convertView;
    }
}
