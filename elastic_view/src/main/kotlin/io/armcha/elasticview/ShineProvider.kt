package io.armcha.elasticview

import android.graphics.*
import android.support.v4.content.ContextCompat
import android.view.View

internal class ShineProvider(parentView: View) : CentrePointProvider(parentView) {

    private val _paint by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.FILL
        }
    }

    private val _centreColor by lazy {
        ContextCompat.getColor(parentView.context, R.color.startColor)
    }
    private val _shineRadius by lazy {
        parentView.height / 2.5f
    }

    fun onDispatchDraw(canvas: Canvas?) {
        _paint.shader = RadialGradient(cx, cy, _shineRadius, _centreColor,
                Color.TRANSPARENT, Shader.TileMode.CLAMP)
        canvas?.drawCircle(cx, cy, _shineRadius, _paint)
    }
}