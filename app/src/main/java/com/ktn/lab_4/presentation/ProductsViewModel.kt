package com.ktn.lab_4.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ktn.lab_4.data.local.Product

class ProductsViewModel: ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product:LiveData<Product> = _product

    fun setProduct(newProduct:Product){
        _product.value = newProduct
    }
}