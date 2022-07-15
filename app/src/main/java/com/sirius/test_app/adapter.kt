package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecyclerAdapter(val userList: List<ReviewModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.review_card, parent, false)
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.authorName.text = userList[position].userName;
        holder.review.text = userList[position].message;
        holder.date.text = userList[position].date;
        Picasso.with(holder.authorAvatar.context).load(userList[position].userImage).into(holder.authorAvatar)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorName = itemView.findViewById<TextView>(R.id.authorName)
        val authorAvatar = itemView.findViewById<ImageView>(R.id.authorAvatar)
        val date = itemView.findViewById<TextView>(R.id.dateText)
        val review = itemView.findViewById<TextView>(R.id.reviewText)
    }

}