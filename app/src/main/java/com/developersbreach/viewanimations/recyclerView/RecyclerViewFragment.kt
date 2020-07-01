package com.developersbreach.viewanimations.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.viewanimations.R

class RecyclerViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.sports_recycler_view)
        val list = Sports.sportsList(requireContext())
        val adapter = SportsAdapter(list, sportsItemListener)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        RecyclerViewItemDecoration.setItemSpacing(
            resources,
            recyclerView
        )
    }

    private val sportsItemListener = SportsAdapter.OnClickListener { sports, _ ->
        val direction: NavDirections =
            RecyclerViewFragmentDirections.ListToDetailFragment(sports)
        findNavController().navigate(direction)
    }

    override fun onResume() {
        super.onResume()
        startLinearAnimation(recyclerView)
    }

    private fun startLinearAnimation(view: RecyclerView) {
        view.translationY = 800f
        val viewPropertyAnimator = view.animate()
        viewPropertyAnimator.translationY(0f)
        viewPropertyAnimator.duration = 300L
        viewPropertyAnimator.start()
    }
}