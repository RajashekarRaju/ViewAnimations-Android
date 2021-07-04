package com.developersbreach.viewanimations.motion.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.developersbreach.viewanimations.databinding.FragmentListMotionDetailBinding
import com.developersbreach.viewanimations.recyclerView.Sports
import com.google.android.material.transition.MaterialContainerTransform
import java.util.concurrent.TimeUnit

class ListMotionDetailFragment : Fragment() {

    private lateinit var binding: FragmentListMotionDetailBinding
    private lateinit var sportsArgs: Sports

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sportsArgs = ListMotionDetailFragmentArgs.fromBundle(requireArguments()).motionDetailArgs
        postponeEnterTransition(500L, TimeUnit.MILLISECONDS)
        sharedElementEnterTransition = MaterialContainerTransform()
        sharedElementReturnTransition = MaterialContainerTransform()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentListMotionDetailBinding.inflate(inflater, container, false)

        binding.motionListDetailImageItem.setImageResource(sportsArgs.banner)
        binding.motionDetailContainer.transitionName = sportsArgs.title

        return binding.root
    }
}