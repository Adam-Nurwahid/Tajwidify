package com.kuliah.pkm.tajwidify.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.pkm.tajwidify.DoaDataClass
import com.kuliah.pkm.tajwidify.MateriActivity
import com.kuliah.pkm.tajwidify.R

class AdapterMenuDoa(private val listdoa: ArrayList<DoaDataClass>) : RecyclerView.Adapter<AdapterMenuDoa.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_doa, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val doaData: DoaDataClass = listdoa[position]
        holder.tvName.text = doaData.name

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, MateriActivity::class.java)
            // You might want to pass some data to MateriActivity using intent here
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listdoa.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name_doa)
    }
}
