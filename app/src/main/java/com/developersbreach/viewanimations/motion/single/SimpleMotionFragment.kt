package com.developersbreach.viewanimations.motion.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.developersbreach.viewanimations.R
import com.google.android.material.transition.MaterialContainerTransform

class SimpleMotionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_motion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = view.findViewById(R.id.motion_image_item)

        imageView.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                imageView to getString(R.string.motion_transition_name)
            )
            findNavController().navigate(R.id.motionToMotionDetailFragment, null, null, extras)
        }
    }
}