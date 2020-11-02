package com.alsharany.fragmentreviw

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ColorFragment.SendData {
    lateinit var blueBtn:Button
    lateinit var redBtn:Button
    lateinit var myTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blueBtn=findViewById(R.id.blue_btn)
        redBtn=findViewById(R.id.red_btn)
        myTextView=findViewById(R.id.reslut_tv)
        blue_btn.setOnClickListener {
            val currentFragment=supportFragmentManager.findFragmentById(R.id.fragment_container)
            val ftr=supportFragmentManager.beginTransaction()
            val fragment=ColorFragment.newInstance("blue")
            ftr.replace(R.id.fragment_container,fragment).commit()
        }
        redBtn.setOnClickListener {
            val currentFragment=supportFragmentManager.findFragmentById(R.id.fragment_container)
            val ftr=supportFragmentManager.beginTransaction()
            val fragment=ColorFragment.newInstance("red")
            ftr.replace(R.id.fragment_container,fragment).commit()
        }
    }

    override fun onSendData(color: String?) {
        myTextView.setText("your color is $color")
        if(color=="blue")
        myTextView.setTextColor(Color.BLUE)
        else if(color=="red")
            myTextView.setTextColor(Color.RED)
        val currentFragment=supportFragmentManager.findFragmentById(R.id.fragment_container_2)
        val ftr=supportFragmentManager.beginTransaction()
        val fragment=RecieverFragment.newInstance(color)
        ftr.replace(R.id.fragment_container_2,fragment,"reciev").commit()


    }
}