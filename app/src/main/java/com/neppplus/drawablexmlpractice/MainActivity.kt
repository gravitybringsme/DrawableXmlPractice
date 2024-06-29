package com.neppplus.drawablexmlpractice

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var toastBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 기본 액션바를 불러내자
//        val defaultActionBar = supportActionBar!!
        val defaultActionBar = supportActionBar

        if(defaultActionBar != null) {
            defaultActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM


            // 실제로 어떤 커스텀뷰를 사용할건지?
            defaultActionBar.setCustomView(R.layout.my_custom_action_bar)

            val toolbar = defaultActionBar.customView.parent as Toolbar
            toolbar.setContentInsetsAbsolute(0,0)

            toastBtn = defaultActionBar.customView.findViewById(R.id.toastBtn)
            
            toastBtn.setOnClickListener {
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
            }
        }
    }
}