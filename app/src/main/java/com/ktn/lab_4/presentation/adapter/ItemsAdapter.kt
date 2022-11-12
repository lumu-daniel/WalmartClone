package com.ktn.lab_4.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.Product
import kotlinx.android.synthetic.main.product_item.view.*
import javax.inject.Inject

class ItemsAdapter @Inject constructor(
    val glide:RequestManager
):RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    class ItemViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView)

    private val diffCallBack = object : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem==newItem
        }
    }

    private val differ = AsyncListDiffer(this,diffCallBack)

    var items:List<Product>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private var onProductClickListener: ((Product)->Unit)? = null

    fun setOnProductClickListener(listener: (Product)->Unit){
        onProductClickListener = listener
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val product = items[position]
        holder.itemView.apply {
            glide.load(product.image).into(pdt_image)
            pdt_title.text = product.title
            price.text = product.price.toString()
            color.text = product.color

            setOnClickListener{
                onProductClickListener?.let {
                    it(product)
                }
            }
        }
    }
}