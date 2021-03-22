package com.elhady.ijobs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.databinding.ItemJobBinding

/**
 * Created by islam elhady on 22-Mar-21.
 */
class MainAdapter(
    private val itemJob: ArrayList<Jobs>,
    private val clickListener: OnItemJobClickListener
) :
    RecyclerView.Adapter<MainAdapter.JobsViewHolder>() {

    class JobsViewHolder(
        private val binding: ItemJobBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Jobs, action: OnItemJobClickListener) {

            binding.apply {
                jobs = item
                executePendingBindings()
            }

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        return JobsViewHolder(
            ItemJobBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = itemJob.size

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bind(itemJob[position], clickListener)
    }

    fun addJobsList(jobList: List<Jobs>) {
        this.itemJob.apply {
            clear()
            addAll(jobList)
        }
    }

    interface OnItemJobClickListener {
        fun onItemClick(jobs: Jobs, position: Int)
    }
}