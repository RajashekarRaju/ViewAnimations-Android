package com.developersbreach.viewanimations.coorodinated

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.developersbreach.viewanimations.R
import com.developersbreach.viewanimations.databinding.FragmentCoordinatedMotionBinding


class CoordinatedMotionFragment : Fragment() {

    private lateinit var binding: FragmentCoordinatedMotionBinding
    private lateinit var parent: ConstraintLayout
    private var checkedItem = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        binding = FragmentCoordinatedMotionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parent = binding.coordinationMotionParent
        startAnimation(
            android.R.interpolator.overshoot,
            parent,
            requireContext()
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_coordinaion_layout, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.animate_again_menu_item -> startAnimation(
                android.R.interpolator.overshoot,
                parent,
                requireContext()
            )
            R.id.animate_category_menu_item -> showProfileDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("InlinedApi")
    private fun showProfileDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val items = resources.getStringArray(R.array.animation_category)

        builder.setSingleChoiceItems(items, checkedItem) { dialog, which ->
            when (which) {
                0 -> startAnimation(
                    android.R.interpolator.accelerate_cubic,
                    parent,
                    requireContext()
                )
                1 -> startAnimation(
                    android.R.interpolator.accelerate_decelerate,
                    parent,
                    requireContext()
                )
                2 -> startAnimation(
                    android.R.interpolator.accelerate_quad,
                    parent,
                    requireContext()
                )
                3 -> startAnimation(
                    android.R.interpolator.accelerate_quint,
                    parent,
                    requireContext()
                )
                4 -> startAnimation(
                    android.R.interpolator.anticipate,
                    parent,
                    requireContext()
                )
                5 -> startAnimation(
                    android.R.interpolator.anticipate_overshoot,
                    parent,
                    requireContext()
                )
                6 -> startAnimation(
                    android.R.interpolator.bounce,
                    parent,
                    requireContext()
                )
                7 -> startAnimation(
                    android.R.interpolator.decelerate_cubic,
                    parent,
                    requireContext()
                )
                8 -> startAnimation(
                    android.R.interpolator.decelerate_quad,
                    parent,
                    requireContext()
                )
                9 -> startAnimation(
                    android.R.interpolator.fast_out_extra_slow_in,
                    parent,
                    requireContext()
                )
                10 -> startAnimation(
                    android.R.interpolator.fast_out_linear_in,
                    parent,
                    requireContext()
                )
                11 -> startAnimation(
                    android.R.interpolator.fast_out_slow_in,
                    parent,
                    requireContext()
                )
                12 -> startAnimation(
                    android.R.interpolator.linear,
                    parent,
                    requireContext()
                )
                13 -> startAnimation(
                    android.R.interpolator.linear_out_slow_in,
                    parent,
                    requireContext()
                )
                14 -> startAnimation(
                    android.R.interpolator.overshoot,
                    parent,
                    requireContext()
                )
            }
            builder.setTitle("Select Animation")
            checkedItem = which
            dialog.dismiss()
        }
        val alert: AlertDialog = builder.create()
        alert.show()
    }
}