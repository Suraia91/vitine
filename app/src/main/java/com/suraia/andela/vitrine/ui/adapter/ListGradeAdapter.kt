package com.suraia.andela.vitrine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suraia.andela.vitrine.data.model.Dado
import com.suraia.andela.vitrine.data.model.Dados
import com.suraia.andela.vitrine.data.model.Dads
import com.suraia.andela.vitrine.databinding.ItemGradesBinding
import com.suraia.andela.vitrine.databinding.ItemTtableBinding

class ListGradeAdapter: ListAdapter <Dads, ListGradeAdapter.ViewHolder>(DiffCallbacks()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding = ItemGradesBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemGradesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Dads){
            binding.testg.text=item.turma.codigo
        }
    }


}
class DiffCallbacks : DiffUtil.ItemCallback<Dads>() {
    override fun areItemsTheSame(oldItem: Dads, newItem: Dads) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Dads, newItem: Dads) = oldItem.turma == newItem.turma

}