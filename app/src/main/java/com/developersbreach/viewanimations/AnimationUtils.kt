package com.developersbreach.viewanimations

import android.animation.Animator
import android.content.Context
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.card.MaterialCardView
import kotlin.math.hypot

fun startCircularFillingEffect(
    cardView: MaterialCardView,
    context: Context
) {
    // get the left bottom corner for the clipping circle
    cardView.setCardBackgroundColor(
        context.resources.getColor(
            R.color.colorCardChange,
            context.theme
        )
    )
    val cx = cardView.right
    val cy = cardView.top
    // get the final radius for the clipping circle
    val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
    // create the animator for this view (the start radius is zero)
    val animator = ViewAnimationUtils.createCircularReveal(
        cardView, cx, cy, 0f, finalRadius
    )
    // Starts the animation.
    animator.duration = 1000L
    animator.start()

    animator.addListener(object : Animation(), Animator.AnimatorListener {

        override fun onAnimationEnd(p0: Animator?) {
            fadeOutViewAnimation(cardView, context)
            cardView.visibility = View.INVISIBLE
        }

        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
        }
    })
}

fun fadeOutViewAnimation(
    view: View,
    context: Context
): Animation {
    val animFadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_exit)
    view.startAnimation(animFadeOut)
    return animFadeOut
}