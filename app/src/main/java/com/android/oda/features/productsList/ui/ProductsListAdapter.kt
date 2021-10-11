package com.android.oda.features.productsList.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.android.oda.data.shopping.ProductItem

class ProductsListAdapter(
    private val productClickListener: ((ProductItem) -> Unit),
    private val quantityChangedListener: ((Int, Float) -> Unit)
) : ListAdapter<ProductItem, ProductItemViewHolder>(PRODUCT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder.create(
            parent,
            productClickListener,
            quantityChangedListener
        )
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, position) }
    }

    companion object {
        private val PRODUCT_COMPARATOR = object : DiffUtil.ItemCallback<ProductItem>() {
            override fun areItemsTheSame(
                oldItem: ProductItem,
                newItem: ProductItem
            ): Boolean = oldItem.product.id == newItem.product.id

            override fun areContentsTheSame(
                oldItem: ProductItem,
                newItem: ProductItem
            ): Boolean = oldItem == newItem
        }
    }
}