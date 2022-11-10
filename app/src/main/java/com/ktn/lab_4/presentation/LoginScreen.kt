package com.ktn.lab_4.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.LocalDataSource.localUsers
import com.ktn.lab_4.utils.Chores.showToast
import kotlinx.android.synthetic.main.fragment_login_screen.*


/**
 * A simple [Fragment] subclass.
 * Use the [LoginScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginScreen : Fragment(R.layout.fragment_login_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signIn?.setOnClickListener {
            val password = enter_password_et.findViewById<TextInputEditText>(R.id.enter_password_et).text.toString()
            val email = enter_email_et.findViewById<TextInputEditText>(R.id.enter_email_et).text.toString()
            if(localUsers.filter { it.userName_email == email }.map { it.password }.contains(password)){
                findNavController().navigate(
                    LoginScreenDirections.actionLoginScreenToCategoriesScreen()
                )
            }else{
                Toast.makeText(context,"User Not Known",LENGTH_LONG).show()
            }
        }

        create_act_btn?.setOnClickListener {
            findNavController().navigate(
                LoginScreenDirections.actionLoginScreenToSignUpScreen()
            )
        }

        forgot_pw_btn?.setOnClickListener{

            val password = enter_password_et.findViewById<TextInputEditText>(R.id.enter_password_et).text.toString()
            val email = enter_email_et.findViewById<TextInputEditText>(R.id.enter_email_et).text.toString()
            if(!email.isEmpty()){
                if(localUsers.map { it.password }.contains(email)){
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:")
                    intent.putExtra(Intent.EXTRA_EMAIL, email)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "$email's password")

                    startActivity(Intent.createChooser(intent, password))
                }else{
                    showToast(context,"User doesn't exist please create account")
                }
            }else{
                showToast(context,"Email Is empty")
            }
        }
    }

}