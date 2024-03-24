package com.example.atalaycelik202003011080quiz5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StadiumAdapter(private val stadiumList: List<Stadium>) : RecyclerView.Adapter<StadiumAdapter.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onLikeClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val capacityTextView: TextView = itemView.findViewById(R.id.capacityTextView)
        val stadiumImage: ImageView = itemView.findViewById(R.id.stadiumImage)
        val likeButton: ImageView = itemView.findViewById(R.id.likeButton)

        init {
            likeButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onLikeClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stadium, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = stadiumList[position]

        holder.nameTextView.text = currentItem.name
        holder.locationTextView.text = currentItem.location
        holder.capacityTextView.text = currentItem.capacity
        holder.stadiumImage.setImageResource(currentItem.imageResourceId)
    }

    override fun getItemCount(): Int {
        return stadiumList.size
    }
}