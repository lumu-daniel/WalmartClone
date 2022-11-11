package com.ktn.lab_4.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.ktn.lab_4.presentation.adapter.CategoriesAdapter
import javax.inject.Inject

class WalmartFragmentFactory @Inject constructor(
    val glide: RequestManager,
    val categoriesAdapter: CategoriesAdapter
):FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            CategoriesFragment::class.java.name -> CategoriesFragment(categoriesAdapter)
            else -> super.instantiate(classLoader, className)
        }

    }
}