package com.developersbreach.viewanimations.simpleTransition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developersbreach.viewanimations.databinding.FragmentSimpleTransitionsBinding


class SimpleTransitionsFragment : Fragment() {

    private lateinit var binding: FragmentSimpleTransitionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSimpleTransitionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardFillingAndFade.setOnClickListener {
            startCircularFillingEffect(
                binding.cardFillingAndFade,
                requireContext()
            )

            fadeOutViewAnimation(
                binding.cardFillingAndFade,
                requireContext()
            )
        }

        binding.cardFilling.setOnClickListener {
            startCircularFillingEffect(
                binding.cardFilling,
                requireContext()
            )
        }

        binding.cardFadeExit.setOnClickListener {
            fadeOutViewAnimation(
                binding.cardFadeExit,
                requireContext()
            )
        }
    }
}