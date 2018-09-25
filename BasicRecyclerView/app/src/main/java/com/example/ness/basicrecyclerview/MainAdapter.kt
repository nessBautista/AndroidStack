package com.example.ness.basicrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        holder.itemView.textView_videoTitle.text = video.name
    }
}

class CustomViewHolder(v: View):RecyclerView.ViewHolder(v){

}