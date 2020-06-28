package com.developersbreach.viewanimations.simpleTransition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developersbreach.viewanimations.R
import com.developersbreach.viewanimations.fadeOutViewAnimation
import com.developersbreach.viewanimations.startCircularFillingEffect
import com.google.android.material.card.MaterialCardView


class SimpleTransitionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_transitions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fillFadeExitCardView = view.findViewById<MaterialCardView>(R.id.card_filling_and_fade)
        val fillCardView = view.findViewById<MaterialCardView>(R.id.card_filling)
        val fadeExitCardView = view.findViewById<MaterialCardView>(R.id.card_fade_exit)

        fillFadeExitCardView.setOnClickListener {
            startCircularFillingEffect(fillFadeExitCardView, requireContext())
            fadeOutViewAnimation(fillFadeExitCardView, requireContext())
        }

        fillCardView.setOnClickListener {
            startCircularFillingEffect(fillCardView, requireContext())
        }

        fadeExitCardView.setOnClickListener {
            fadeOutViewAnimation(fadeExitCardView, requireContext())
        }
    }
}