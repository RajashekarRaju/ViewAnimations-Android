package com.developersbreach.viewanimations.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.developersbreach.viewanimations.databinding.FragmentDetailBinding
import java.util.concurrent.TimeUnit


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var sportsArgs: Sports

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        sportsArgs = DetailFragmentArgs.fromBundle(args).sportsArgs
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        postponeEnterTransition(250, TimeUnit.MILLISECONDS)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailImageView.setImageResource(sportsArgs.banner)
        binding.titleDetailTextView.text = sportsArgs.title
        binding.aboutDetailTextView.text = sportsArgs.about

        binding.detailImageView.transitionName = sportsArgs.banner.toString()
        binding.titleDetailTextView.transitionName = sportsArgs.title
    }
}