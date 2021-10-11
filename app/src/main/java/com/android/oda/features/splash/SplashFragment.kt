package com.android.oda.features.splash

import androidx.navigation.fragment.findNavController
import com.android.oda.R
import com.android.oda.appUtilities.base.BaseFragment
import com.android.oda.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<SplashViewModel,
        FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun configureUI() {
        findNavController().navigate(R.id.action_splashFragment_to_productsListFragment)
    }
}