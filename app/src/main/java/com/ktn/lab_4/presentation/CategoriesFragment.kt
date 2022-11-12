package com.ktn.lab_4.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.LocalDataSource.localCategories
import com.ktn.lab_4.presentation.adapter.CategoriesAdapter
import com.ktn.lab_4.utils.Constants.GRID_SPAN_COUNT
import com.ktn.lab_4.utils.Constants.currentUser
import kotlinx.android.synthetic.main.fragment_categories_screen.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment @Inject constructor(
    private val categoryAdapter: CategoriesAdapter
) : Fragment(R.layout.fragment_categories_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email.text = currentUser?.userName_email
        categoryAdapter.setCategoryClickListener {
            findNavController().navigate(
                CategoriesFragmentDirections.actionCategoriesScreenToItemsFragment()
            )
        }
        setRecyclerView()
    }

    private fun setRecyclerView(){
        categoryAdapter.items = localCategories
        categoriesList.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(context,GRID_SPAN_COUNT)
        }
    }

}