package com.example.horsegame

import android.graphics.Point
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableRow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        initScreegame()
    }

    private fun initScreegame() {
        setSizeBoard()
        hideMessage()
    }

    private fun hideMessage() {
        var lyMessage = findViewById<LinearLayout>(R.id.lyMessage)
        lyMessage.visibility = View.INVISIBLE
    }

    private fun setSizeBoard() {
        var iv: ImageView

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x

        var width_dp = (width / resources.displayMetrics.density)

        val lateralMarginDP = 0
        val widht_cell = (width_dp - lateralMarginDP)/8
        val heigth_cell = widht_cell

        for (i in 0..7){
            for (j in 0..7){

                iv = findViewById(resources.getIdentifier("c$i$j","id",packageName))

                var height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heigth_cell, resources.displayMetrics).toInt()
                var width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heigth_cell, resources.displayMetrics).toInt()
                iv.layoutParams = TableRow.LayoutParams(width,height)

            }
        }
    }
}