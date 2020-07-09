package com.developersbreach.viewanimations.motion.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.viewanimations.R
import com.developersbreach.viewanimations.recyclerView.Sports

class MotionAdapter(
    private val sportsList: List<Sports>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<MotionAdapter.MotionViewHolder>() {

    class MotionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val container: View = itemView.findViewById(R.id.motion_item_container)
        private val banner: ImageView = itemView.findViewById(R.id.motion_item_image_view)

        fun bind(
            sports: Sports,
            onClickListener: OnClickListener
        ) {
            banner.setImageResource(sports.banner)
            container.transitionName = sports.title
            itemView.setOnClickListener {
                onClickListener.onClick(sports, container)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotionViewHolder {
        return MotionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_motion,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MotionViewHolder, position: Int) {
        val sports: Sports = sportsList[position]
        holder.bind(sports, onClickListener)
    }

    override fun getItemCount() = sportsList.size

    class OnClickListener(val clickListener: (Sports, View) -> Unit) {
        fun onClick(
            sports: Sports,
            container: View
        ) = clickListener(sports, container)
    }
}