package com.niumandzi.panto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class FrameView(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttrs:Int = 0
) : View(context, attrs, defaultAttrs) {

    private val painter = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        isAntiAlias = true
        strokeWidth = 20f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
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

            val minus =

            drawColor(Color.BLACK)
            //left up frame
            drawLine(leftUPcornerSTARTx, leftUPcornerSTARTy, leftUPdirectionSTOPx + 50, leftUPdirectionSTOPy, painter)
            drawLine(leftUPcornerSTARTx, leftUPcornerSTARTy, leftUPdirectionSTOPx, leftUPdirectionSTOPx + 50, painter)
            //right up frame
            drawLine(rightUPcornerSTARTx, rightUPcornerSTARTy, rightUPdirectionSTOPx - 50, rightUPdirectionSTOPy, painter)
            drawLine(rightUPcornerSTARTx, rightUPcornerSTARTy, rightUPdirectionSTOPx, rightUPdirectionSTOPy + 50, painter)
            //left down frame
            drawLine(leftDOWNcornerSTARTx, leftDOWNcornerSTARTy, leftDOWNdirectionSTOPx + 50, leftDOWNdirectionSTOPy, painter)
            drawLine(leftDOWNcornerSTARTx, leftDOWNcornerSTARTy, leftDOWNdirectionSTOPx, leftDOWNdirectionSTOPy - 50, painter)
            //right down frame
            drawLine(rightDOWNcornerSTARTx, rightDOWNcornerSTARTy, rightDOWNdirectionSTOPx, rightDOWNdirectionSTOPy - 50, painter)
            drawLine(rightDOWNcornerSTARTx, rightDOWNcornerSTARTy, rightDOWNdirectionSTOPx - 50, rightDOWNdirectionSTOPy, painter)
        }
    }
}

