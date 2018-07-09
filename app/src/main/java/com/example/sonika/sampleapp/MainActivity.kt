package com.example.sonika.sampleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_blank.*
import com.example.sonika.sampleapp.toast
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val fm = this.supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.container, BlankFragment())
            ft.commit()

    }
}

