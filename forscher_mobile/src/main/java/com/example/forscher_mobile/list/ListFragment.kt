package com.example.forscher_mobile.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forscher_mobile.databinding.FragmentListBinding
import com.example.forscher_mobile.main.MainActivity
import com.example.forscher_mobile.model.Poi
import com.example.forscher_mobile.model.PoiItemX
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listPoi: ArrayList<PoiItemX>
    private lateinit var poiAdapter: poiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listBinding= FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listPoi= loadMockPoiFromJson()

        poiAdapter = poiAdapter(listPoi, onItemClicked ={onPoiClicked(it)} )

        listBinding.poiRecyclerView.apply {

            layoutManager= LinearLayoutManager(context)
            adapter=poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItemX> {

        val poiString: String = context?.assets?.open("poi.json")?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        val data = gson.fromJson(poiString, Poi::class.java)
        return data
    }

    private fun onPoiClicked(poi: PoiItemX) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))


    }
}