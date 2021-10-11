package com.android.oda.appUtilities.extensions

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.android.oda.appUtilities.util.ui.components.toolbar.Toolbar
import com.android.oda.appUtilities.util.ui.components.toolbar.ToolbarConfig
import com.android.oda.features.mainActivity.MainActivity
import com.android.oda.features.mainActivity.ToolbarHost

fun Fragment.hideToolbar() {
    (activity as MainActivity).hideToolbar()
}

fun Fragment.showToolbar() {
    (activity as MainActivity).showToolbar()
}

fun Fragment.getToolbar() {
    (activity as MainActivity).getToolbar()
}

fun Fragment.setToolbarTitle(@StringRes title: Int) {
    (activity as MainActivity).getToolbar().setTitle(getString(title))
}

fun Fragment.setToolbarConfig(config: ToolbarConfig): Toolbar {
    val host = activity
    if (host is ToolbarHost) {
        return host.setToolbarConfig(config)
    } else throw IllegalStateException("Activity is not toolbar host")
}

