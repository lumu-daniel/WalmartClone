package com.ktn.lab_4.data.local

data class Category (
    val name: String,
    val imageResource: Int,
    val items: List<Product>?=null
    )