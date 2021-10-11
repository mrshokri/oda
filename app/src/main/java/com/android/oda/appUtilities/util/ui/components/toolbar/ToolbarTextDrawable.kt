package com.android.oda.appUtilities.util.ui.components.toolbar

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import androidx.annotation.IntRange
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.android.oda.R


class ToolbarTextDrawable constructor(
        private val mContext: Context,
        @StringRes textResource: Int
) : Drawable() {

    private val mPaint = TextPaint()

    private val mText: String by lazy {
        mContext.getString(textResource)
    }

    private val mTextBounds = Rect()

    override fun getIntrinsicWidth(): Int {
        return mTextBounds.width()
    }

    override fun getIntrinsicHeight(): Int {
        return (56 * mContext.resources.displayMetrics.density).toInt()
    }

    override fun draw(canvas: Canvas) {
        val x: Int = bounds.width() / 2
        val fm = mPaint.fontMetrics
        val centerY = canvas.height / 2
        val y = centerY - (fm.descent + fm.ascent)
        canvas.drawText(mText, x.toFloat(), y.toFloat(), mPaint)
    }

    override fun setAlpha(@IntRange(from = 0, to = 255) i: Int) {}

    override fun setColorFilter(colorFilter: ColorFilter?) {}

    override fun getOpacity(): Int = PixelFormat.OPAQUE

    init {
        mPaint.color = ContextCompat.getColor(mContext, R.color.toolbar_text_icon)
        mPaint.style = Paint.Style.FILL
        mPaint.textAlign = Paint.Align.CENTER
        mPaint.textSize = mContext.resources.getDimension(R.dimen.toolbar_icon_text_size)
        mPaint.getTextBounds(mText, 0, mText.length, mTextBounds)
    }
}