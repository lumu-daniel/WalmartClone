package com.ktn.lab_4.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ktn.lab_4.R
import kotlinx.android.synthetic.main.fragment_add_items.*

class AddItemsFragment: Fragment(R.layout.fragment_add_items) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener{
            val andVersion = androidVersion.text.toString()
            val andCode = androidCode.text.toString()

            val tableRow = TableRow(context)
            val layoutParams =
            tableRow.apply {
                layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(0,10,0,10)
                }
            }.addView(
                TextView(context).apply {
                    text = andCode
                    height = 80
                    gravity = Gravity.CENTER
                    background = simpleTextView1.background
                    textSize = 14f
                    setTextColor(Color.BLACK)

            },0)
            tableRow.addView(
                TextView(context).apply {
                    text = andVersion
                    height = 80
                    gravity = Gravity.CENTER
                    background = simpleTextView2.background
                    textSize = 14f
                    setTextColor(Color.BLACK)
            },0)
            table.addView(tableRow)

        }

        next.setOnClickListener{
            findNavController().navigate(
                AddItemsFragmentDirections.actionAddItemsFragmentToLoginScreen()
            )
        }
    }
}