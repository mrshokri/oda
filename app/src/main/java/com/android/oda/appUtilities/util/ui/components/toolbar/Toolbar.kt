package com.android.oda.appUtilities.util.ui.components.toolbar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.ImageViewCompat
import com.android.oda.R
import com.android.oda.databinding.ToolbarBinding


class Toolbar : FrameLayout {

    constructor(context: Context) : super(context) {
        initialize(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize(context, attrs, defStyleAttr)
    }

    private lateinit var binding: ToolbarBinding

    private fun initialize(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {
        binding = ToolbarBinding.inflate(LayoutInflater.from(context), this, true)

        setElevation()

        if (isInEditMode) {
            setTitle("Title")
        }
    }

    private fun setElevation() {
        val elevation = resources.getDimensionPixelSize(R.dimen.toolbar_elevation).toFloat()
        ViewCompat.setElevation(this, elevation)
    }

    private fun removeElevation() {
        ViewCompat.setElevation(this, 0f)
    }

    fun setConfig(config: ToolbarConfig) {
        if (config.elevated) {
            setElevation()
        } else {
            removeElevation()
        }

        setStartIcon(config.startIcon)

        setTitle(config.title)

        setExtraContent(config.extraContent)

        binding.layoutEndicons.removeAllViews()
        config.icons?.forEach { addIcon(it) }

        binding.progressBar.visibility = if (config.showProgressBar) VISIBLE else GONE

        fun getColor(@ColorRes id: Int) = ResourcesCompat.getColor(resources, id, null)

        val bgColor: Int = getColor(R.color.toolbar_background)
        val color: Int = getColor(R.color.toolbar_text)
        transitionBackgroundColor(bgColor)
        ImageViewCompat.setImageTintList(binding.iconStart, ColorStateList.valueOf(color))
        binding.textTitle.setTextColor(color)
    }

    private fun setStartIcon(def: IconDefinition) {
        val icon = binding.iconStart
        when {
            def.iconResource != 0 -> {
                icon.setImageResource(def.iconResource)
                icon.setOnClickListener(def.clickListener)
            }
            def.icon != null -> {
                icon.setImageDrawable(def.icon)
                icon.setOnClickListener(def.clickListener)
            }
            else -> {
                icon.setOnClickListener(null)
            }
        }
    }

    private fun transitionBackgroundColor(to: Int) {
        val transitionDrawable = TransitionDrawable(arrayOf(background, ColorDrawable(to)))
        transitionDrawable.startTransition(resources.getInteger(R.integer.animation_duration_medium))
        background = transitionDrawable
    }

    fun setTitle(text: String) {
        binding.textTitle.text = text
    }

    fun setExtraContent(extraContent: Int) {
        binding.layoutExtra.removeAllViews()
        if (0 != extraContent) {
            inflate(context, extraContent, binding.layoutExtra)
        }
    }

    private fun addIcon(def: IconDefinition) {
        val icon = AppCompatImageView(context)
        val size = resources.getDimension(R.dimen.toolbar_icon_size).toInt()
        var width = size

        icon.scaleType = ImageView.ScaleType.CENTER

        when {
            def.iconResource != 0 -> {
                icon.setImageResource(def.iconResource)
                icon.setOnClickListener(def.clickListener)
            }
            def.icon != null -> {
                if (def.icon is ToolbarTextDrawable) {
                    width = def.icon.intrinsicWidth
                }
                icon.setImageDrawable(def.icon)
                icon.setOnClickListener(def.clickListener)
            }
            else -> {
                icon.setOnClickListener(null)
            }
        }

        val outValue = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackgroundBorderless,
            outValue,
            true
        )
        icon.setBackgroundResource(outValue.resourceId)

        val tint = R.color.toolbar_text
        val iconColor = ResourcesCompat.getColor(resources, tint, null)
        ImageViewCompat.setImageTintList(icon, ColorStateList.valueOf(iconColor))

        val params = LayoutParams(width, size)
        binding.layoutEndicons.addView(icon, params)
    }

}