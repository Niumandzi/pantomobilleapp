package com.niumandzi.panto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class FrameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttrs:Int = 0
) : View(context, attrs, defaultAttrs) {

    private val painter = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        isAntiAlias = true
        strokeWidth = 25f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {

            val long = (0.09 * height).toFloat()

            //left up corner
            val leftUPcornerSTARTx = 0.toFloat()
            val leftUPcornerSTARTy = 0.toFloat()
            //left up
            val leftUPdirectionSTOPx = 0.toFloat()
            val leftUPdirectionSTOPy = 0.toFloat()

            //right up corner
            val rightUPcornerSTARTx = (width).toFloat()
            val rightUPcornerSTARTy = 0.toFloat()
            //right up
            val rightUPdirectionSTOPx = (width).toFloat()
            val rightUPdirectionSTOPy = 0.toFloat()

            //left down corner
            val leftDOWNcornerSTARTx = 0.toFloat()
            val leftDOWNcornerSTARTy = (height).toFloat()
            //left up
            val leftDOWNdirectionSTOPx = 0.toFloat()
            val leftDOWNdirectionSTOPy = (height).toFloat()

            //left down corner
            val rightDOWNcornerSTARTx = (width).toFloat()
            val rightDOWNcornerSTARTy = (height).toFloat()
            //left up
            val rightDOWNdirectionSTOPx = (width).toFloat()
            val rightDOWNdirectionSTOPy = (height).toFloat()

            //left up frame
            drawLine(leftUPcornerSTARTx, leftUPcornerSTARTy, leftUPdirectionSTOPx + long, leftUPdirectionSTOPy, painter)
            drawLine(leftUPcornerSTARTx, leftUPcornerSTARTy, leftUPdirectionSTOPx, leftUPdirectionSTOPx + long, painter)
            //right up frame
            drawLine(rightUPcornerSTARTx, rightUPcornerSTARTy, rightUPdirectionSTOPx - long, rightUPdirectionSTOPy, painter)
            drawLine(rightUPcornerSTARTx, rightUPcornerSTARTy, rightUPdirectionSTOPx, rightUPdirectionSTOPy + long, painter)
            //left down frame
            drawLine(leftDOWNcornerSTARTx, leftDOWNcornerSTARTy, leftDOWNdirectionSTOPx + long, leftDOWNdirectionSTOPy, painter)
            drawLine(leftDOWNcornerSTARTx, leftDOWNcornerSTARTy, leftDOWNdirectionSTOPx, leftDOWNdirectionSTOPy - long, painter)
            //right down frame
            drawLine(rightDOWNcornerSTARTx, rightDOWNcornerSTARTy, rightDOWNdirectionSTOPx, rightDOWNdirectionSTOPy - long, painter)
            drawLine(rightDOWNcornerSTARTx, rightDOWNcornerSTARTy, rightDOWNdirectionSTOPx - long, rightDOWNdirectionSTOPy, painter)
        }
    }
}

