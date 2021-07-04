package com.hovietlong.tonghopbaivenha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class playerAdapter extends ArrayAdapter {
    Context context;
    Integer resource;
    ArrayList<Player> data;

    public playerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Player> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        Player player = data.get(position);
        ImageView ivAvatar = convertView.findViewById(R.id.ivAvatar);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvGoal = convertView.findViewById(R.id.tvGoal);
        TextView tvCountry = convertView.findViewById(R.id.tvCountry);

        ivAvatar.setImageResource(player.getAvatar());
        tvName.setText(player.getName());
        tvGoal.setText(player.getGoal().toString());
        tvCountry.setText(player.getCountry());
        return convertView;
    }
}
