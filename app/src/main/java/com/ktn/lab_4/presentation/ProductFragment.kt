package com.ktn.lab_4.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.Product
import kotlinx.android.synthetic.main.fragment_product.*
import javax.inject.Inject

class ProductFragment @Inject constructor(
    val glide: RequestManager
): Fragment(R.layout.fragment_product) {

    lateinit var viewModel: ProductsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ProductsViewModel::class.java]
        setView(viewModel.product.value)
    }

    private fun setView(product:Product?){
        glide.load(product?.image).into(product_Image)
        product_Id.text = product?.itemId
        product_color.text = product?.color
        product_title.text = product?.title
        product_description.text = product?.desc
    }
}