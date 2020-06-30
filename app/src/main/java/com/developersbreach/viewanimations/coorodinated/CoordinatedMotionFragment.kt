package com.developersbreach.viewanimations.coorodinated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.developersbreach.viewanimations.R


class CoordinatedMotionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coordinated_motion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parentLayout = view.findViewById<ConstraintLayout>(R.id.coordination_motion_parent)
        val interpolator =
            AnimationUtils.loadInterpolator(
                context,
                android.R.interpolator.linear_out_slow_in
            )
        var offset = resources.getDimensionPixelSize(300.toInt()).toFloat()

        val children = parentLayout.childCount
        for (i in 0 until children) {
            val childAt = parentLayout.getChildAt(i)
            childAt.visibility = View.VISIBLE
            childAt.translationY = offset
            childAt.alpha = 0.85f
            childAt.animate()
                .translationY(0f)
                .alpha(1f)
                .setInterpolator(interpolator)
                .setDuration(2000L)
                .start()
            offset *= 1.5f
        }
    }
}