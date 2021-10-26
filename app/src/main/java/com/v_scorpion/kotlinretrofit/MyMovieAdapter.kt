package com.v_scorpion.kotlinretrofit


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.v_scorpion.kotlinretrofit.databinding.ItemLayoutBinding

class MyMovieAdapter(val list: MutableList<PojoMovie>) : RecyclerView.Adapter<MyMovieAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(list[position].imageurl).into(holder.binding.imageMovie)
        holder.binding.txtName.text = list[position].name
        holder.binding.txtTeam.text = list[position].team
        holder.binding.txtCreatedby.text = list[position].createdby
    }

    override fun getItemCount(): Int {
        return list.size
    }
}