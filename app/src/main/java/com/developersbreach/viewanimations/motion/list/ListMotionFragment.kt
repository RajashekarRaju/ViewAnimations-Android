package com.developersbreach.viewanimations.motion.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.viewanimations.R
import com.developersbreach.viewanimations.recyclerView.RecyclerViewItemDecoration
import com.developersbreach.viewanimations.recyclerView.Sports


class ListMotionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_motion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.motion_list_recycler_view)

        val list = Sports.sportsList(requireContext())
        val adapter = MotionAdapter(list, sportsItemListener)
        recyclerView.adapter = adapter

        RecyclerViewItemDecoration.setItemSpacing(
            resources,
            recyclerView
        )
    }

    private val sportsItemListener = MotionAdapter.OnClickListener { sports, container ->
        val direction: NavDirections =
            ListMotionFragmentDirections.listMotionToMotionDetailFragment(sports)

        val extras = FragmentNavigatorExtras(
            container to sports.title
        )

        findNavController().navigate(direction, extras)
    }
}