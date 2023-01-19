package com.geektechkb.android7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektechkb.android7.fragment.FirstFragment
import com.geektechkb.android7.fragment.SecondFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, FirstFragment())
            .commit()
    }
}