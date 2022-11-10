package com.ktn.lab_4.utils

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext

object Chores {

    fun showToast(@ApplicationContext context: Context?, string: String){
        Toast.makeText(context,string, Toast.LENGTH_LONG).show()
    }
}