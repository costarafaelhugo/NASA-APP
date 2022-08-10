package com.hugorafaelcosta.nasaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hugorafaelcosta.nasaapp.dataViewModel.DataMainViewModel
import com.hugorafaelcosta.nasaapp.databinding.FragmentDataImageBinding
import com.hugorafaelcosta.nasaapp.models.DataModel


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


        viewModel.explanation_liveData.observe(viewLifecycleOwner) {
            binding.imageDescriptionTv.text = it


            viewModel.copyright_liveData.observe(viewLifecycleOwner) {
                binding.copyrightTv.text = it
            }

            viewModel.image_HDR.observe(viewLifecycleOwner) {

                val bindData = DataModel("", "", "", "")
                val requestOptions = RequestOptions()
                    //.placeholder(R.drawable.galaxia)
                    .error(R.drawable.ic_launcher_background)

                Glide.with(binding.imageIv)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(bindData.image)
                    .into(binding.imageIv)
            }

//            Picasso.with(context).load(bindData.image).into(binding.imageIv)
//
//

//            Picasso.with(context)
//                .load(bindData.image)
//                .into(binding.imageIv)

        }
    }
}