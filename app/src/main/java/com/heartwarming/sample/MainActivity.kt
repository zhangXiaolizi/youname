package com.heartwarming.sample

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (index in 1..10) {
            val textView = TextView(this).apply {
                val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100)
                this.layoutParams = lp
                gravity = Gravity.CENTER
                setTextColor(Color.WHITE)

                //askdjalksdjalsjdkalksdjalsd


                println("asdjaksdlaksda")
                ColorHelper.getColorOfIndex(Color.WHITE, 1)


                println("123123123123132")


                println("asdasdasda--------------")
                println("asdasdasda--------------++++++++++++++")

                println("aksjdaldaskdja")

                println("asdasdasda-------sdjfklsjdfks-------")



                println("asdalksdal国立")



                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN



                val color = ColorHelper.getColorOfIndex(Color.parseColor("#12b666"), index)
                text = "#${Color.red(color).toString(16)}${Color.green(color).toString(16)}${
                    Color.blue(color).toString(16)
                }"
                setBackgroundColor(color)
                root_view.addView(this)
            }
        }

    }
}