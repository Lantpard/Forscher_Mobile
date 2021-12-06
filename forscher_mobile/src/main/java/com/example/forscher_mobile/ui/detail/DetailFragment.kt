package com.example.forscher_mobile.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.forscher_mobile.R
import com.example.forscher_mobile.databinding.FragmentDetailBinding
import com.example.forscher_mobile.maps.MapsFragment
import com.example.forscher_mobile.ui.main.MainActivity
import com.google.android.gms.maps.SupportMapFragment
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poi = args.poi

        with(detailBinding){
            nameTextView.text=poi.name
            generalTextView.text=poi.general
            locationTextView.text=poi.location
            coordinatesTextView.text=poi.coordinates
            temperatureTextView.text=poi.temperature
            recommendationsTextView.text=poi.recommendations
            //Picasso.get().load(poi.urlLocal).into(pictureImageView)
            Picasso.get().load(poi.urlPicture).into(pictureImageView)

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(poi=poi))
            }
        }

        /*val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)*/

    }


}