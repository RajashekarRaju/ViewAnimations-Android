package com.developersbreach.viewanimations.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.viewanimations.databinding.ItemSportsBinding

class SportsAdapter(
    private val sportsList: List<Sports>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    class SportsViewHolder(
        private val binding: ItemSportsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            sports: Sports,
            onClickListener: OnClickListener
        ) {
            binding.sportsItemImageView.setImageResource(sports.banner)
            binding.titleItemTextView.text = sports.title
            binding.sportsItemImageView.transitionName = sports.banner.toString()
            binding.titleItemTextView.transitionName = sports.title

            itemView.setOnClickListener {
                onClickListener.onClick(
                    sports,
                    binding.sportsItemImageView,
                    binding.titleItemTextView
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        return SportsViewHolder(
            ItemSportsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sports: Sports = sportsList[position]
        holder.bind(sports, onClickListener)
    }

    override fun getItemCount() = sportsList.size

    class OnClickListener(val clickListener: (Sports, ImageView, TextView) -> Unit) {
        fun onClick(
            sports: Sports,
            iconImageView: ImageView,
            title: TextView
        ) = clickListener(sports, iconImageView, title)
    }
}