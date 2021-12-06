package com.example.forscher_mobile.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forscher_mobile.databinding.FragmentListBinding
import com.example.forscher_mobile.ui.main.MainActivity
import com.example.forscher_mobile.model.PoiItemX


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private var listPoi: ArrayList<PoiItemX> = arrayListOf()
    private lateinit var poiAdapter: poiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listBinding= FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider( this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        //listViewModel.loadMockPoiFromJson(context?.assets?.open("poi.json"))

        listViewModel.getPoiFromServer()

        listViewModel.onPoiLoaded.observe(viewLifecycleOwner, { result ->
            onPoiLoadedSubscribed(result)
        })

        poiAdapter = poiAdapter(listPoi, onItemClicked ={onPoiClicked(it)} )

        listBinding.poiRecyclerView.apply {

            layoutManager= LinearLayoutManager(context)
            adapter=poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiLoadedSubscribed(result: ArrayList<PoiItemX>?) {
        result?.let{ listPoi->
            poiAdapter.appendItems(listPoi)

        }
    }


    private fun onPoiClicked(poi: PoiItemX) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))


    }
}