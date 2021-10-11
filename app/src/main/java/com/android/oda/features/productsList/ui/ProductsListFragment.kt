package com.android.oda.features.productsList.ui

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.android.oda.R
import com.android.oda.appUtilities.base.BaseFragment
import com.android.oda.appUtilities.extensions.asPriceFormatted
import com.android.oda.appUtilities.extensions.asTotalNumberFormatted
import com.android.oda.appUtilities.extensions.hideToolbar
import com.android.oda.data.shopping.ProductItem
import com.android.oda.databinding.FragmentProductsListBinding
import com.android.oda.features.productsList.ProductsListViewModel


class ProductsListFragment :
    BaseFragment<ProductsListViewModel, FragmentProductsListBinding>(FragmentProductsListBinding::inflate) {

    private lateinit var adapter: ProductsListAdapter
    private var isTheFirstTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ProductsListAdapter(
            productClickListener = {
                goToProductDetails(it)
            },
            quantityChangedListener = { newQuantity, totalPrice ->
                viewModel.quantityChanged(newQuantity, totalPrice)
            }
        )
    }

    private fun goToProductDetails(product: ProductItem) {

    }

    override fun configureUI() {
        hideToolbar()
        configureTransactionList()
    }

    override fun configureObservers() {
        viewModel.productsListResult.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it.items)
            }
        })

        viewModel.shoppingInfo.observe(viewLifecycleOwner, {
            if (isTheFirstTime) {
                showShoppingSummary()
                isTheFirstTime = false
            } else {
                if (it.first == 0) {
                    hideShoppingSummary()
                    isTheFirstTime = true
                }
            }
            binding.numberOfProducts.text = it.first.toString().asTotalNumberFormatted()
            binding.totalPrice.text = it.second.asPriceFormatted()
        })
    }

    private fun showShoppingSummary() {
        val bottomUp: Animation = AnimationUtils.loadAnimation(
            context,
            R.anim.bottom_up
        )
        binding.shoppingSection.startAnimation(bottomUp)
        binding.shoppingSection.visibility = VISIBLE
    }

    private fun hideShoppingSummary() {
        val bottomDown: Animation = AnimationUtils.loadAnimation(
            context,
            R.anim.bottom_down
        )
        binding.shoppingSection.startAnimation(bottomDown)
        binding.shoppingSection.visibility = GONE
    }

    private fun configureTransactionList() {
        binding.productsList.adapter = adapter
    }

}