package com.example.studentproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_row_hero, parent, false)
            viewHolder = ViewHolder()
            viewHolder.imgItemPhoto = view.findViewById(R.id.img_item_photo)
            viewHolder.tvItemName = view.findViewById(R.id.tv_item_name)
            viewHolder.tvItemNim = view.findViewById(R.id.tv_item_nim)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val hero = getItem(position) as Hero
        Glide.with(parent!!.context)
            .load(hero.photo)
            .into(viewHolder.imgItemPhoto)
        viewHolder.tvItemName.text = hero.name
        viewHolder.tvItemNim.text = hero.nim

        view?.setOnClickListener {
            val intentDetail = Intent(parent.context, DetailActivity::class.java)
            intentDetail.putExtra("key_hero", hero)
            parent.context.startActivity(intentDetail)
        }

        return view!!
    }

    override fun getItem(position: Int): Any {
        return listHero[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listHero.size
    }

    private inner class ViewHolder {
        lateinit var imgItemPhoto: ImageView
        lateinit var tvItemName: TextView
        lateinit var tvItemNim: TextView
    }
}
