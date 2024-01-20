package com.badshahapps.hindireceipe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badshahapps.hindireceipe.databinding.PopularItemRvBinding
import com.bumptech.glide.Glide

class PopularAdapter(private val dataList: List<Recipe>, private val context: Context) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: PopularItemRvBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding=PopularItemRvBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Load image using Glide
        Glide.with(context).load(dataList.get(position).img).into(holder.binding.popularImg)

        // Set text for the title
        holder.binding.popularTxt.text = dataList.get(position).tittle

        // Split the 'ing' string and set the first part as text for popularTime
        val time = dataList.get(position).ing.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        holder.binding.popularTime.text = time[0]
    }
}