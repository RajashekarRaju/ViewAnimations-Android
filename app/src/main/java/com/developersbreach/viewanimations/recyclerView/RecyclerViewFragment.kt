package com.developersbreach.viewanimations.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.developersbreach.viewanimations.R

class RecyclerViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.sports_recycler_view)
        val list = Sports.sportsList(requireContext())
        val adapter = SportsAdapter(list, sportsItemListener)
        recyclerView.adapter = adapter

        // When user hits back button transition takes backward
        postponeEnterTransition()
        recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }

        RecyclerViewItemDecoration.setItemSpacing(
            resources,
            recyclerView
        )
    }

    private val sportsItemListener = SportsAdapter.OnClickListener { sports, imageView, textView ->
        val direction: NavDirections =
            RecyclerViewFragmentDirections.ListToDetailFragment(sports)

        val extras = FragmentNavigatorExtras(
            imageView to sports.banner.toString(),
            textView to sports.title
        )

        findNavController().navigate(direction, extras)
    }
}