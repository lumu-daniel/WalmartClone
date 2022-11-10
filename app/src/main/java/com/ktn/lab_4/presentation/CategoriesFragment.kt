package com.ktn.lab_4.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ktn.lab_4.R
import com.ktn.lab_4.presentation.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.fragment_categories_screen.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment @Inject constructor(
    private val adapter: CategoriesAdapter
) : Fragment(R.layout.fragment_categories_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setCategoryClickListener {
            /**
             * Add
            * */
        }
    }

    fun setRecyclerView(){
        categoriesList.adapter = adapter
    }

}