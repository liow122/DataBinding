package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val myContact: Contact= Contact("ZeMing","012345")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        binding.contact = myContact

        binding.buttonDone.setOnClickListener{
            changeContact(it)
        }

    }

    private fun changeContact(it: View?){
        binding.apply{
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhone.text.toString()
            this.invalidateAll()
        }
    }
}
