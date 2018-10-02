package com.example.muhamin.speechbee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Muhamin on 02-Oct-18.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    private Context mContext;
    private List<Upload> mUploads;

    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.
                image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadcurrent = mUploads.get(position);
        Glide.with(mContext)
                .load(uploadcurrent.getmImageUrl())
                .into(holder.imgView);

    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imgView =  itemView.findViewById(R.id.image_view);
        }
    }

}
