package com.example.imageapi.view

import androidx.recyclerview.widget.DiffUtil
import com.example.imageapi.model.ImageModel

class ImageDiffUtil(
    private var oldList: List<ImageModel>,
    private var newList: List<ImageModel>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}