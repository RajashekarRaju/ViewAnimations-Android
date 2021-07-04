package com.developersbreach.viewanimations.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.developersbreach.viewanimations.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = Sports.sportsList(requireContext())
        val adapter = SportsAdapter(list, sportsItemListener)
        binding.sportsRecyclerView.adapter = adapter

        // When user hits back button transition takes backward
        postponeEnterTransition()
        binding.sportsRecyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }

        RecyclerViewItemDecoration.setItemSpacing(
            resources,
            binding.sportsRecyclerView
        )
    }

    private val sportsItemListener = SportsAdapter.OnClickListener { sports, imageView, textView ->
        val direction: NavDirections = RecyclerViewFragmentDirections.listToDetailFragment(sports)

        val extras = FragmentNavigatorExtras(
            imageView to sports.banner.toString(),
            textView to sports.title
        )

        findNavController().navigate(direction, extras)
    }
}