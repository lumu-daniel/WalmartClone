package com.ktn.lab_4.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.LocalDataSource
import com.ktn.lab_4.presentation.adapter.ItemsAdapter
import kotlinx.android.synthetic.main.fragment_items.*
import javax.inject.Inject

class ItemsFragment @Inject constructor(
    val itemsAdapter: ItemsAdapter
): Fragment(R.layout.fragment_items) {

    lateinit var viewModel: ProductsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ProductsViewModel::class.java]
        itemsAdapter.items = LocalDataSource.localProducts
        itemsAdapter.setOnProductClickListener {
            viewModel.setProduct(it)
            findNavController().navigate(
                ItemsFragmentDirections.actionItemsFragmentToProductFragment()
            )
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        categoryItems.apply {
            adapter = itemsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}