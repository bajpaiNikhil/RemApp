package com.example.remapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val rotateOpen:  Animation  by lazy {AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy {AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim)}
    private val fromBottom:  Animation  by lazy {AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim)}
    private val toBottom:    Animation    by lazy {AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim)}

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn.setOnClickListener{
            onAddButtonClicked()
        }
        edit_btn.setOnClickListener {
            Toast.makeText(this,"Edit button" , Toast.LENGTH_LONG).show()

            val i = Intent(this,FormActivity::class.java)
            startActivity(i)

        }
        list_btn.setOnClickListener {
            Toast.makeText(this,"List buttom pressed" , Toast.LENGTH_LONG).show()
        }
    }

    fun onAddButtonClicked() {
        setVisiblity(clicked)
        setAnimation(clicked)
        setCLickable(clicked)
        clicked = !clicked
    }

    fun setAnimation(clicked:Boolean) {
        if(!clicked){
            edit_btn.visibility = View.VISIBLE
            list_btn.visibility = View.VISIBLE
        }else{
            edit_btn.visibility = View.INVISIBLE
            list_btn.visibility = View.INVISIBLE
        }
    }

    fun setVisiblity(clicked: Boolean) {
        if(!clicked){
            edit_btn.startAnimation(fromBottom)
            list_btn.startAnimation(fromBottom)
            add_btn.startAnimation(rotateOpen)
        }else{
            edit_btn.startAnimation(toBottom)
            list_btn.startAnimation(toBottom)
            add_btn.startAnimation(rotateClose)
        }
    }

    fun setCLickable(Clicked:Boolean){
        if(!clicked){
            edit_btn.isClickable = true
            list_btn.isClickable = true
        }else{
            edit_btn.isClickable = false
            list_btn.isClickable = false
        }
    }
}















