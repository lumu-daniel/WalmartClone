package com.ktn.lab_4.presentation

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ktn.lab_4.R
import kotlinx.android.synthetic.main.fragment_quiz.*
import java.time.LocalDateTime

class QuizFragment: Fragment(R.layout.fragment_quiz) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit.setOnClickListener {
            var result = 0
            if(answer_1.isChecked&&answer_2.isChecked){
                result+=100
            }else if(answer_1.isChecked||answer_2.isChecked){
                result+=50
            }
            AlertDialog.Builder(context).apply {
                setTitle("Quiz Result")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    setMessage("“Congratulations! You submitted on ${LocalDateTime.now()}, Your achieved $result %")
                }
                setNegativeButton("Close") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                create()
            }.show()
        }
        next.setOnClickListener {
            findNavController().navigate(
                QuizFragmentDirections.actionQuizFragmentToLoginScreen()
            )
        }
    }
}