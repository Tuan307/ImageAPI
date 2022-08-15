package com.example.imageapi.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageapi.databinding.ImageLayoutBinding
import com.example.imageapi.model.ImageModel

class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private var oldList = emptyList<ImageModel>()

    inner class ViewHolder(private val binding: ImageLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

        }
        fun bind(item: ImageModel) {
            binding.apply {
                Glide.with(context).load(item.urls.full).into(imageView)
                txtCreatedBy.text = "Created by " + item.user.name
                txtLikeImage.text = item.likes.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ImageLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(oldList[position])

    override fun getItemCount(): Int {
        return oldList.size
    }

    fun setData(newList: List<ImageModel>) {
        val diffUtil = ImageDiffUtil(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}