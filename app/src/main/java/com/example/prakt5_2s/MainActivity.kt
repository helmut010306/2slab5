package com.example.prakt5_2s

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.button);
        val button2: Button = findViewById(R.id.button2);

        val textView: TextView = findViewById(R.id.textView);
        val imageView: ImageView  = findViewById(R.id.imageView3);

        val popupMenu = androidx.appcompat.widget.PopupMenu(this, button2)
        popupMenu.inflate(R.menu.popupmenu)

        val popupMenu2 = PopupMenu(this, button)
        popupMenu2.inflate(R.menu.popupmenu2)

        val popupMenu3 = androidx.appcompat.widget.PopupMenu(this, textView)
        popupMenu3.inflate(R.menu.popupmenu3)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.menu1 -> {
                    textView.text = "Нажат пункт 1"
                    true
                }
                R.id.menu2 -> {
                    textView.text = "Нажат пункт 2"
                    true
                }
                R.id.menu3 -> {
                    textView.text = "Нажат пункт 3"
                    true
                }
                else -> false
            }
        }
        popupMenu2.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.red -> {
                    textView.background = ColorDrawable(Color.RED)
                    textView.text = "Вы выбрали красный цвет"
                }
                R.id.yellow -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "Вы выбрали желтый цвет"
                }
                R.id.green -> {
                    textView.background = ColorDrawable(Color.GREEN)
                    textView.text = "Вы выбрали зеленый цвет"
                }
            }
            false
        }
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.Q){
            popupMenu2.setForceShowIcon((true))
        }

        popupMenu3.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.menu1 -> {
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24F)
                    textView.text = "Шрифт 24"
                }
                R.id.menu2 -> {
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 34F)
                    textView.text = "Шрифт 34"
                }
                R.id.menu3 -> {
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 48F)
                    textView.text = "Шрифт 48"
                }
            }
            false
        }

        textView.setOnClickListener{
            popupMenu3.show()
        }

        button.setOnClickListener{
            popupMenu2.show()
        }

        imageView.setOnClickListener{
            popupMenu.show()
        }
    }
}