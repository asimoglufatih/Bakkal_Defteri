package com.example.bakkaldefteri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bakkaldefteri.database.Spending
import com.example.bakkaldefteri.databinding.ItemSpendingBinding


class SpendingRCCallBack: DiffUtil.ItemCallback<Spending>() {

    override fun areItemsTheSame(oldItem: Spending, newItem: Spending): Boolean {
        return oldItem.spendingId == newItem.spendingId
    }

    override fun areContentsTheSame(oldItem: Spending, newItem: Spending): Boolean {
        return oldItem == newItem
    }
}

class ClickWatcher(val clickWatcher: (spendingId: Long) -> Unit) {
    fun clicked(spending: Spending) = clickWatcher(spending.spendingId)
}

class SpendingRCAdapter(private val clickWatcher: ClickWatcher) :
    ListAdapter<Spending, SpendingRCAdapter.ViewHolder>(SpendingRCCallBack()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpendingRCAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SpendingRCAdapter.ViewHolder, position: Int) {
        val item =getItem(position)
        holder.bind(item,clickWatcher)
    }

    class ViewHolder private constructor(private val binding: ItemSpendingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Spending, clickWatcher: ClickWatcher) {
            binding.spending=item
            binding.executePendingBindings()
            binding.clickWatcher = clickWatcher
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSpendingBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}