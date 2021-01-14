package com.srstudios.food_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val bundle=intent.extras!!
        aifoodimg.setImageResource(bundle.getInt("image"))
        aifoodname.text=bundle.getString("name")
        aifooddetails.text=bundle.getString("des")
    }
}
