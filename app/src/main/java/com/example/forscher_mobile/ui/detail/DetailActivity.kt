package com.example.forscher_mobile.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.forscher_mobile.databinding.ActivityDetailBinding
import com.example.forscher_mobile.model.PoiItemX

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val poi: PoiItemX = intent.extras?.getSerializable("poi") as PoiItemX

        with(detailBinding){
            nameTextView.text=poi.name
            generalTextView.text=poi.general
            locationTextView.text=poi.location
            coordinatesTextView.text=poi.coordinates
            temperatureTextView.text=poi.temperature
            recommendationsTextView.text=poi.recommendations
            Picasso.get().load(poi.urlPicture).into(pictureImageView)

        }


    }
}