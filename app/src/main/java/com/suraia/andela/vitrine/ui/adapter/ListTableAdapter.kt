package com.suraia.andela.vitrine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suraia.andela.vitrine.data.model.Dado
import com.suraia.andela.vitrine.data.model.Dados
import com.suraia.andela.vitrine.databinding.ItemTtableBinding

class ListTableAdapter: ListAdapter <Dados, ListTableAdapter.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding = ItemTtableBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemTtableBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Dados){
            binding.test.text=item.codigo
        }
    }


}
class DiffCallback : DiffUtil.ItemCallback<Dados>() {
    override fun areItemsTheSame(oldItem: Dados, newItem: Dados) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Dados, newItem: Dados) = oldItem.id == newItem.id

}