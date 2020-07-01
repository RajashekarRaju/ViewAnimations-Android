package com.developersbreach.viewanimations.coorodinated

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import androidx.constraintlayout.widget.ConstraintLayout


fun startAnimation(
    animationType: Int,
    parent: ConstraintLayout,
    context: Context
) {
    val interpolator = makeAnimation(animationType, context)
    var offset = 300.toFloat()

    val children = parent.childCount
    for (i in 0 until children) {
        val childAt = parent.getChildAt(i)
        childAt.visibility = View.VISIBLE
        childAt.translationY = offset
        childAt.alpha = 0.85f
        childAt.animate()
            .translationY(0f)
            .alpha(1f)
            .setInterpolator(interpolator)
            .setDuration(1500L)
            .start()
        offset *= 1.5f
    }
}

fun makeAnimation(interpolatorType: Int, context: Context): Interpolator {
    return AnimationUtils.loadInterpolator(
        context,
        interpolatorType
    )
}