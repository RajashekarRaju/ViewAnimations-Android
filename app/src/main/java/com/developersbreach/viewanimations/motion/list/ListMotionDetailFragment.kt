package com.developersbreach.viewanimations.motion.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.developersbreach.viewanimations.R
import com.developersbreach.viewanimations.recyclerView.Sports
import com.google.android.material.transition.MaterialContainerTransform

class ListMotionDetailFragment : Fragment() {

    private lateinit var sportsArgs: Sports

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sportsArgs = ListMotionDetailFragmentArgs.fromBundle(requireArguments()).motionDetailArgs
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_motion_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val container: View = view.findViewById(R.id.motion_detail_container)
        val banner: ImageView = view.findViewById(R.id.motion_list_detail_image_item)

        banner.setImageResource(sportsArgs.banner)
        container.transitionName = sportsArgs.title
    }
}