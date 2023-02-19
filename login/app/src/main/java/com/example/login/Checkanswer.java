package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Checkanswer extends BaseAdapter {
    ArrayList lsData;
    LayoutInflater inflater;

    public Checkanswer(ArrayList lsData, Context context) {
        this.lsData = lsData;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question data = (Question) getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_listresult,null);
            holder.txtdapan= (TextView) convertView.findViewById(R.id.txtresult);
            holder.txtcauhoi= (TextView) convertView.findViewById(R.id.txtquestion);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        int i = position +1;
        holder.txtcauhoi.setText("Cau "+ i + ":");
        holder.txtdapan.setText(data.getTraloi());

        return convertView;
    }

    private static class ViewHolder{

        public TextView txtdapan,txtcauhoi;
    }
}