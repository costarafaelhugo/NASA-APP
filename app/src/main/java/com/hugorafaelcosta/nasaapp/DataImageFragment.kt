package com.hugorafaelcosta.nasaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels

import com.hugorafaelcosta.nasaapp.dataViewModel.DataMainViewModel
import com.hugorafaelcosta.nasaapp.databinding.FragmentDataImageBinding


class DataImageFragment : Fragment() {

    private val viewModel: DataMainViewModel by viewModels()
    private lateinit var binding: FragmentDataImageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDataImageBinding.inflate(layoutInflater)
        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            viewModel.getDataImages()


        viewModel._liveData.observe(viewLifecycleOwner) {
            binding.imageDescriptionIv.text = it
        }

    }
}