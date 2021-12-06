package com.example.forscher_mobile.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forscher_mobile.R
import com.example.forscher_mobile.ui.detail.DetailActivity
import com.example.forscher_mobile.model.Poi
import com.example.forscher_mobile.model.PoiItemX
import com.google.gson.Gson

class ListPOIActivity : AppCompatActivity() {

    private lateinit var listPoi: ArrayList<PoiItemX>
    private lateinit var poiAdapter: poiAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poiactivity)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        //listPoi = createMockPoi()

        listPoi= loadMockPoiFromJson()

        poiAdapter = poiAdapter(listPoi, onItemClicked ={onPoiClicked(it)} )

        poiRecyclerView.apply {

            layoutManager=LinearLayoutManager(context)
            adapter=poiAdapter
            setHasFixedSize(false)
        }



    }

    private fun onPoiClicked(poi: PoiItemX) {

        var intent = Intent (this,DetailActivity::class.java)

        intent.putExtra("poi",poi)
        startActivity(intent)

    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItemX> {

        val poiString: String = applicationContext.assets.open("poi.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val data = gson.fromJson(poiString, Poi::class.java)
        return data
    }

    /*private fun createMockPoi() : ArrayList<Poi>{
        return arrayListOf(

            Poi(
                name = "Casa Terracota",
                description ="xxxx",
                urlPicture = "https://cr00.epimg.net/radio/imagenes/2019/02/23/el_sabor_de_colombia/1550880075_834677_1550880989_noticia_normal.jpg"
            ),
            Poi(
                name = "Viñedo Ain Karim",
                description ="xxxx",
                urlPicture = "https://i0.wp.com/revistadiners.com.co/wp-content/uploads/2021/09/vinedo_villa_de_leyva_.jpg"
            )
            ,
            Poi(
                name = "Desierto",
                description ="xxxx",
                urlPicture = "https://chipviajero.com/wp-content/uploads/2017/02/C%C3%B3mo-Llegar-A-Las-C%C3%A1rcavas-De-Villa-De-Leyva-Chip-Viajero-1.jpg"
            )
            ,
            Poi(
                name = "Pozos Azules",
                description ="xxxx",
                urlPicture = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Pozos_Azules_en_Villa_de_Leyva.jpg/1200px-Pozos_Azules_en_Villa_de_Leyva.jpg"
            )
            ,
            Poi(
                name = "Museo Paleontologico",
                description ="xxxx",
                urlPicture = "https://mibellavilla.com/wp-content/uploads/2018/10/paleontologico06-310x186.jpg"
            )
        )
    }*/
}