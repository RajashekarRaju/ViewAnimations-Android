package com.developersbreach.viewanimations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.developersbreach.viewanimations.coorodinated.startAnimation
import com.developersbreach.viewanimations.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.simpleTransitionMainCardView.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.homeToSimpleTransitionsFragment()
            )
        }

        binding.coordinatedMotionMainCardView.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.homeToCoordinatedMotionFragment()
            )
        }

        binding.recyclerViewMainCardView.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.homeToRecyclerViewFragment()
            )
        }

        binding.motionMainCardView.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.homeToMotionCategoryFragment()
            )
        }

        startAnimation(
            android.R.interpolator.overshoot,
            binding.homeFragmentParent,
            requireContext()
        )
    }
}