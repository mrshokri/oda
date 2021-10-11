package com.android.oda.appUtilities.util.ui.components.toolbar

import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.LayoutRes

class IconDefinition(
        val iconResource: Int = 0,
        val icon: Drawable? = null,
        val clickListener: View.OnClickListener
) {
    companion object {
        fun create(
                iconResource: Int = 0,
                clickListener: View.OnClickListener
        ) = IconDefinition(iconResource, null, clickListener)
        fun create(
                icon: Drawable? = null,
                clickListener: View.OnClickListener
        ) = IconDefinition(0, icon, clickListener)
    }
}

open class ToolbarConfig(
        val startIcon: IconDefinition,
        val title: String,
        @LayoutRes val extraContent: Int = 0,
        val elevated: Boolean = true,
        val showProgressBar: Boolean = false,
        val icons: List<IconDefinition>? = null
)

class SimpleToolbarConfig(
    startIcon: IconDefinition,
    title: String,
    icons: List<IconDefinition>? = null
): ToolbarConfig(
    startIcon,
    title,
    0,
    true,
    false,
    icons
)