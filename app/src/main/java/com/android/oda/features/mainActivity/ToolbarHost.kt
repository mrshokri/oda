package com.android.oda.features.mainActivity

import com.android.oda.appUtilities.util.ui.components.toolbar.Toolbar
import com.android.oda.appUtilities.util.ui.components.toolbar.ToolbarConfig

interface ToolbarHost {
    fun setToolbarConfig(config: ToolbarConfig): Toolbar
}