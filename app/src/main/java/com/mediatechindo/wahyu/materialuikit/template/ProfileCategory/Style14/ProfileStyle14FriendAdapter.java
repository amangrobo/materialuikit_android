package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style14;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle14FriendAdapter extends RecyclerView.Adapter<ProfileStyle14FriendAdapter.ItemViewHolder> {
    private static ArrayList<ProfileStyle14FriendModel> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ProfileStyle14FriendClickListener clicklistener = null;

    public ProfileStyle14FriendAdapter(Context ctx, ArrayList<ProfileStyle14FriendModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemFriendClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ProfileStyle14FriendClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_profile14, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
