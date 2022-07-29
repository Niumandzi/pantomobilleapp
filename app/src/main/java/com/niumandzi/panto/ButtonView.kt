package com.niumandzi.panto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttrs:Int = 0
) : View(context, attrs, defaultAttrs) {

    private val painter = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        isAntiAlias = true
    }
    private val painter1 = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            val radius = (width / 2f)
            val radius1 = (0.4 * radius).toFloat()
            drawCircle(centerX, centerY, radius, painter)
            drawCircle(centerX, centerY, radius1, painter1)
        }
    }
}

