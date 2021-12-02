package com.example.calendertest

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CalendarAdapter (val listdata : ArrayList<CalendarData>,
                       val cureentMonth : Int
                       ): RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    //var listdata = mutableListOf<CalendarData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_day, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listdata.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int ) {
        Log.e("TAG",""+listdata.get(position).month )
        holder.tv_day_num.setTextColor(ContextCompat.getColor(holder.itemView.context,R.color.white))
        holder.iv_day.visibility = View.INVISIBLE
        if (listdata.get(position).month == cureentMonth){
            holder.tv_day_num.alpha = 1f

        }else{
            holder.tv_day_num.alpha = 0.3f
        }

        holder.tv_day_num.text = listdata[position].day.toString()
        holder.itemView.setOnClickListener {
            Log.e("tag",holder.adapterPosition.toString())

            //notifyDataSetChanged()
            if (holder.iv_day.visibility.equals(View.INVISIBLE)){
                holder.iv_day.visibility = View.VISIBLE
                if (position == 6){
                    notifyItemChanged(0)
                }


            }else{
                holder.iv_day.visibility = View.INVISIBLE
            }

        }
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        var tv_day_num: TextView
        var iv_day : ImageView

        constructor(itemView: View) : super(itemView) {

            tv_day_num = itemView.findViewById(R.id.tv_day_num)
            iv_day = itemView.findViewById(R.id.iv_day)

        }

    }
}


