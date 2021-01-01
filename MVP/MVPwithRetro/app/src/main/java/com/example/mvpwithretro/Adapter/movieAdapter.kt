package com.example.mvpwithretro.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpwithretro.Contract.AdapterContract
import com.example.mvpwithretro.Model.Network.DailyBoxOffice
import com.example.mvpwithretro.R

class movieAdapter : RecyclerView.Adapter<movieAdapter.mViewHolder>(), AdapterContract.View,
    AdapterContract.Model {
    var movieList= arrayListOf<DailyBoxOffice>()
    inner class mViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv=view.findViewById<TextView>(R.id.textView)
        fun bind(movie:DailyBoxOffice){
            tv.text=movie.movieNm
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return mViewHolder(view)
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun setData(list:ArrayList<DailyBoxOffice>) {
        movieList=list
    }

}