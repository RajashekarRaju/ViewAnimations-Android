package com.developersbreach.viewanimations.recyclerView

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.viewanimations.R

class RecyclerViewItemDecoration(spacingInPixels: Int) : RecyclerView.ItemDecoration() {

    private var itemOffset = spacingInPixels

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect[itemOffset, itemOffset, itemOffset] = itemOffset
    }

    companion object {

        fun setItemSpacing(
            resources: Resources,
            recyclerView: RecyclerView
        ) {
            val spacingInPixels =
                resources.getDimensionPixelSize(R.dimen.recycler_view_spacing_dimen)
            recyclerView.addItemDecoration(
                RecyclerViewItemDecoration(
                    spacingInPixels
                )
            )
        }
    }
}