package com.projectcarl.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test_tv.setText("Hello Kotlin!!");
        test_iv.setImageResource(R.drawable.banana);

        test_iv.setOnClickListener{
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SplashScreenFragment())
                    .addToBackStack(null)
                    .commit();
            }
        }
    }
}
