package com.example.helloworld_kmm.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.helloworld.DataModels.PlaceholderResult
import com.example.helloworld_kmm.databinding.FragmentPlaceholderBinding

class PlaceholderListRecyclerViewAdapter(
    private var values: List<PlaceholderResult>
) : RecyclerView.Adapter<PlaceholderListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPlaceholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id.toString()
        holder.contentView.text = item.title
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentPlaceholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    fun update(list: List<PlaceholderResult>) {
        values = list
        notifyDataSetChanged()
    }

}