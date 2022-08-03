package com.hugorafaelcosta.nasaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hugorafaelcosta.nasaapp.R
import com.hugorafaelcosta.nasaapp.databinding.ResItemDataBinding
import com.hugorafaelcosta.nasaapp.model.ImageData


class MainAdapter(private val onItemClicked: (ImageData) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {

    private var lives = mutableListOf<ImageData>()

    fun setLiveList(lives: List<ImageData>) {

        this.lives = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemDataBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val live = lives[position]
        holder.bind(live, onItemClicked)
    }

    override fun getItemCount(): Int {
        return lives.size
    }
}

class MainViewHolder(val binding: ResItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(live: ImageData, onItemClicked: (ImageData) -> Unit) {

        binding.copyright.text = live.copyright
        binding.date.text = live.date
        binding.explanation.text = live.explanation

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(live.imageHD)
            .into(binding.imageHD)

        itemView.setOnClickListener {
            onItemClicked(live)
        }

    }

}