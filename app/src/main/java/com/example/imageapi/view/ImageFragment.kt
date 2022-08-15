package com.example.imageapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imageapi.databinding.FragmentImageBinding
import com.example.imageapi.viewmodel.ImageViewModel


class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private val myAdapter by lazy {
        ImageAdapter(requireContext())
    }
    private lateinit var viewModel: ImageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        setUpRecyclerView()
        getData()
//        val snap: SnapHelper = PagerSnapHelper()
//        snap.attachToRecyclerView(binding.recyclerView)
        return binding.root
    }

    private fun getData() {
        viewModel.getImageList().observe(viewLifecycleOwner, Observer {
            myAdapter.setData(it)
            Toast.makeText(activity, it.size.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = myAdapter
        //binding.recyclerView.setItemViewCacheSize(10)
    }

}