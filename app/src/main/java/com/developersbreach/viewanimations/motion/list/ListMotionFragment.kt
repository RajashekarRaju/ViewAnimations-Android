package com.developersbreach.viewanimations.motion.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.developersbreach.viewanimations.databinding.FragmentListMotionBinding
import com.developersbreach.viewanimations.recyclerView.RecyclerViewItemDecoration
import com.developersbreach.viewanimations.recyclerView.Sports
import java.util.concurrent.TimeUnit


class ListMotionFragment : Fragment() {

    private lateinit var binding: FragmentListMotionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListMotionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = Sports.sportsList(requireContext())
        val adapter = MotionAdapter(list, sportsItemListener)
        binding.motionListRecyclerView.adapter = adapter

        postponeEnterTransition(1000L, TimeUnit.MILLISECONDS)

        RecyclerViewItemDecoration.setItemSpacing(
            resources,
            binding.motionListRecyclerView
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