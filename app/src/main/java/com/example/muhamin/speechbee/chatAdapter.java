package com.example.muhamin.speechbee;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class chatAdapter extends ArrayAdapter {
    private Activity context;
    private List<Message> msgList;

    public chatAdapter(@NonNull Activity context, List<Message> msgList) {
        super(context, R.layout.message_item, msgList);
        this.context = context;
        this.msgList = msgList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View msgItem = inflater.inflate(R.layout.message_item, null, true);
        //TODO set data

        TextView sender = msgItem.findViewById(R.id.sender);
        TextView content = msgItem.findViewById(R.id.message);

        Message msg = msgList.get(position);

        sender.setText(msg.getSender());
        content.setText(msg.getContent());

        return msgItem;
    }
}
