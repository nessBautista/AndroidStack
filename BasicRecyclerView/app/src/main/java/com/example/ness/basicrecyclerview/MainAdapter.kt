package com.example.ness.basicrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed):RecyclerView.Adapter<CustomViewHolder>(){

    val videoTitles = listOf("first title", "second title", "third title")
    //number of cells
    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    //Creation of the custom vire
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.itemView.textView_videoTitle.text = video.name + " ~ " + "20k Views\n4 days ago"
        holder.itemView.textView_channelName.text = video.channel.name

        //load images
        val thumbnailImageView = holder.itemView.img_video
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        val channelProfileView = holder.itemView.img_profile
        Picasso.get().load(video.channel.profileImageUrl).into(channelProfileView)
    }
}

class CustomViewHolder(v: View):RecyclerView.ViewHolder(v){

}