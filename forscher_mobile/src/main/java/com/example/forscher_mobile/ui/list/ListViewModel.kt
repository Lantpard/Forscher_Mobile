package com.example.forscher_mobile.ui.list


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forscher_mobile.data.PoiRepository
import com.example.forscher_mobile.model.Poi
import com.example.forscher_mobile.model.PoiItemX
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream


class ListViewModel : ViewModel(){
    private var poiLoad : MutableLiveData<ArrayList<PoiItemX>> = MutableLiveData()
    val onPoiLoaded : LiveData<ArrayList<PoiItemX>> = poiLoad

    private val repository = PoiRepository()

    fun getPoiFromServer(){
        GlobalScope.launch (Dispatchers.IO){
            poiLoad.postValue(repository.getPoi())
        }
    }

    fun loadMockPoiFromJson(poiString: InputStream?) {
        val poiString = poiString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        poiLoad.value = gson.fromJson(poiString, Poi::class.java)

    }

}
