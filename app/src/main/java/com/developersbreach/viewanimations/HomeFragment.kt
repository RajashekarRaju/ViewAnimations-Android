package com.developersbreach.viewanimations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.developersbreach.viewanimations.coorodinated.startAnimation
import com.google.android.material.card.MaterialCardView


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialCardView>(R.id.simple_transition_main_card_view).setOnClickListener {
            findNavController().navigate(R.id.homeToSimpleTransitionsFragment)
        }

        view.findViewById<MaterialCardView>(R.id.coordinated_motion_main_card_view).setOnClickListener {
            findNavController().navigate(R.id.homeToCoordinatedMotionFragment)
        }

        view.findViewById<MaterialCardView>(R.id.recycler_view_main_card_view).setOnClickListener {
            findNavController().navigate(R.id.homeToRecyclerViewFragment)
        }

        view.findViewById<MaterialCardView>(R.id.motion_main_card_view).setOnClickListener {
            findNavController().navigate(R.id.homeToMotionFragment)
        }

        val parent: ConstraintLayout = view.findViewById(R.id.home_fragment_parent)
        startAnimation(android.R.interpolator.overshoot, parent, requireContext())
    }
}