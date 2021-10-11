package com.android.oda.features.productsList.ui

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.oda.R
import com.android.oda.appUtilities.extensions.asGrossFormatted
import com.android.oda.appUtilities.extensions.asGrossFormattedPerUnit
import com.android.oda.data.shopping.ProductItem
import com.android.oda.databinding.ItemProductBinding

class ProductItemViewHolder(
    private val binding: ItemProductBinding,
    private val productClickListener: ((ProductItem) -> Unit),
    private val quantityChangedListener: ((Int, Float) -> Unit)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductItem, position: Int) {
        item.product.run {
            images[0].thumbnail.url.let { thumbnailUrl ->
                binding.image.load(thumbnailUrl) {
                    placeholder(R.drawable.ic_place_holder)
                }
            }
            if(!item.product.availability.isAvailable){
                binding.addButton.visibility = GONE
                binding.notAvailableBadge.visibility = VISIBLE
            }
            binding.name.text = name

            promotion?.descriptionShort.let {
                binding.promotion.text = it
                binding.promotion.visibility = it?.let { VISIBLE } ?: run { GONE }
            }

            binding.extraInfo.text = nameExtra
            binding.extraInfo.visibility = nameExtra?.let { VISIBLE } ?: run { GONE }

            binding.grossPrice.text = grossPrice.asGrossFormatted()
            binding.totalPrice.text = grossUnitPrice.asGrossFormattedPerUnit()

            checkCounterState(item.quantity)

            binding.addButton.setOnClickListener {
                item.quantity++
                checkCounterState(item.quantity)
                quantityChangedListener.invoke(1, grossPrice.toFloat())
            }

            binding.removeButton.setOnClickListener {
                item.quantity--
                checkCounterState(item.quantity)
                quantityChangedListener.invoke(-1, grossPrice.toFloat() * -1)
            }
        }
    }

    private fun checkCounterState(quantity: Int){
        binding.counter.text = quantity.toString()
        if(quantity != 0 ){
            startCounterState()
        }else{
            stopCounterState()
        }
    }

    private fun startCounterState(){
        binding.addButton.setImageResource(R.drawable.ic_add_gray)
        binding.addButton.setBackgroundResource(R.drawable.item_shopping_button_normal_background)

        binding.removeButton.visibility = VISIBLE
        binding.counter.visibility = VISIBLE
    }

    private fun stopCounterState(){
        binding.addButton.setImageResource(R.drawable.ic_add_purple)
        binding.addButton.setBackgroundResource(R.drawable.item_shopping_button_bold_background)
        binding.removeButton.visibility = GONE
        binding.counter.visibility = GONE
    }

    companion object {
        fun create(
            parent: ViewGroup,
            productClickListener: ((ProductItem) -> Unit),
            quantityChangedListener: ((Int, Float) -> Unit)
        ): ProductItemViewHolder {
            val binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ProductItemViewHolder(
                binding,
                productClickListener,
                quantityChangedListener
            )
        }
    }

}