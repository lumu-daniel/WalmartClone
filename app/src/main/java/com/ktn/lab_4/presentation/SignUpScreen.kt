package com.ktn.lab_4.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.LocalDataSource.localUsers
import com.ktn.lab_4.data.local.User
import com.ktn.lab_4.utils.Chores.showToast
import kotlinx.android.synthetic.main.fragment_sign_up_screen.*

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpScreen : Fragment(R.layout.fragment_sign_up_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sign_up_btn.setOnClickListener {
            val firstName = first_name_et.text.toString()
            val lastName = last_name_et.text.toString()
            val emailAddress = email_address_et.text.toString()
            val password = password_et.text.toString()
            if (firstName.isEmpty()||
                lastName.isEmpty()||
                emailAddress.isEmpty()||
                password.isEmpty()){
                showToast(context,"please enter valid information")
            }else{
                localUsers.add(User(
                    firstName,
                    lastName,
                    emailAddress,
                    password
                ))
                showToast(context,"User Added")
                findNavController().navigate(
                    SignUpScreenDirections.actionSignUpScreenToLoginScreen()
                )
            }
        }
    }


}