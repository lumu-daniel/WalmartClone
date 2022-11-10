package com.ktn.lab_4.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.ktn.lab_4.R
import com.ktn.lab_4.data.local.Category
import kotlinx.android.synthetic.main.category_item.view.*
import javax.inject.Inject

class CategoriesAdapter @Inject constructor(
    val glide: RequestManager
): Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(itemView: View) :ViewHolder(itemView)

    private val callBack = object: ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,callBack)

    var items: List<Category>
        get() = differ.currentList
        set(value)  = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.category_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private var onCategoryClickListener:((Category)->Unit)? = null
    fun setCategoryClickListener(listener:(Category)->Unit){
        onCategoryClickListener = listener
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = items[position]
        holder.itemView.apply {
            glide.load(category.imageResource).into(categoryImage)

            setOnClickListener{
                onCategoryClickListener?.let {
                    it(category)
                }
            }
        }
    }
}