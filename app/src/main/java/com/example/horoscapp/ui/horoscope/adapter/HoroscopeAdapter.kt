package com.example.horoscapp.ui.horoscope.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.horoscapp.R
import com.example.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList(), private val onItemSelected:(HoroscopeInfo) -> Unit): Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false))
    }

    override fun getItemCount(): Int {
        return horoscopeList.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        return holder.render(horoscopeList[position], onItemSelected)
    }

    fun updateList(list: List<HoroscopeInfo>){
        horoscopeList = list
        notifyDataSetChanged()
    }

}