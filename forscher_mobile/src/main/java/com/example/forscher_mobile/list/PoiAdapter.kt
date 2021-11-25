package com.example.forscher_mobile.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forscher_mobile.R
import com.example.model.PoiItemX
import com.squareup.picasso.Picasso


class poiAdapter (
    private val poiList: ArrayList<PoiItemX>,
    private val onItemClicked: (PoiItemX) -> Unit

) : RecyclerView.Adapter<poiAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poi = poiList[position]
        holder.itemView.setOnClickListener {onItemClicked(poiList[position])}
        holder.bind(poi)

    }

    override fun getItemCount(): Int = poiList.size



    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        private var nameTextView: TextView= itemview.findViewById(R.id.name_text_view)
        //private var rankingTextView: TextView= itemview.findViewById(R.id.point_text_view)
        private var desciptionTextView: TextView= itemview.findViewById(R.id.descripcion_text_view)
        private var pictureImageView: ImageView = itemview.findViewById(R.id.picture_image_view)
        private var RatingBar: RatingBar = itemview.findViewById(R.id.ratingBar_text_view)
        fun bind(poi: PoiItemX){
            nameTextView.text=poi.name
            desciptionTextView.text=poi.description
            //rankingTextView.text=poi.ranking.toString()
            Picasso.get().load(poi.urlPicture).into(pictureImageView)
            RatingBar.rating=poi.ranking


        }

    }
}