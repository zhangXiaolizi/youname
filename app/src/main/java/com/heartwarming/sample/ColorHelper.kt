package com.heartwarming.sample

import android.graphics.Color
import androidx.annotation.ColorInt
import java.text.DecimalFormat
import kotlin.math.roundToInt

/**
 * 获取Ant Design的工具类
 */
object ColorHelper {
    private const val hueStep = 2
    private const val saturationStep = 0.16F
    private const val saturationStep2 = 0.05F
    private const val brightnessStep1 = 0.05F
    private const val brightnessStep2 = 0.15F
    private const val lightColorCount = 5
    private const val darkColorCount = 4
    private val format = DecimalFormat("0.00")


    private fun colorToHSV(color: Int): FloatArray {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        return hsv
    }


    private fun getHue(hsv: FloatArray, i: Int, isLight: Boolean): Float {
        var hue: Float
        val h = hsv[0]
        if (h in 60.0..240.0) {
            hue = if (isLight) h - hueStep * i else h + hueStep * i
        } else {
            hue = if (isLight) h + hueStep * i else h - hueStep * i
        }
        if (hue < 0) {
            hue += 360
        } else if (hue >= 360) {
            hue -= 360
        }
        return hue.roundToInt().toFloat()
    }


    private fun getSaturation(hsv: FloatArray, i: Int, isLight: Boolean): Float {
        var saturation: Float
        val s = hsv[1]
        saturation = if (isLight) {
            s - saturationStep * i
        } else if (i == darkColorCount) {
            s + saturationStep
        } else {
            s + saturationStep2 * i
        }

        if (saturation > 1) {
            saturation = 1f
        }
        if (isLight && i == lightColorCount && saturation > 0.1) {
            saturation = 0.1f
        }
        if (saturation < 0.06) {
            saturation = 0.06f
        }
        return format.format(saturation).toFloat()
    }

    private fun getValue(hsv: FloatArray, i: Int, isLight: Boolean): Float {
        var value: Float
        val v = hsv[2]
        if (isLight) {
            value = v + brightnessStep1 * i
        } else {
            value = v - brightnessStep2 * i
        }
        if (value > 1) {
            value = 1f
        }
        return format.format(value).toFloat()
    }


    /**
     * 根据给定的主色值，按照ant design的标准生成指定[index]的色值
     * @param color 原色值
     * @param index 获取指定位置的色值，取值在1..10之间
     */
    fun getColorOfIndex(@ColorInt color: Int, index: Int): Int {
        val isLight = index <= 6
        val hsv = colorToHSV(color)
        val i = if (isLight) lightColorCount + 1 - index else index - lightColorCount - 1

        return Color.HSVToColor(
            floatArrayOf(
                getHue(hsv, i, isLight), getSaturation(hsv, i, isLight),
                getValue(hsv, i, isLight)
            ).apply {
                println("hsv is ${this.contentToString()}")
            }
        )

    }
}