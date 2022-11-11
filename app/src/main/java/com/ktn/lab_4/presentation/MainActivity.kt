package com.ktn.lab_4.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ktn.lab_4.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var walmartFragmentFactory: WalmartFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = walmartFragmentFactory
        setContentView(R.layout.activity_main)
    }
}