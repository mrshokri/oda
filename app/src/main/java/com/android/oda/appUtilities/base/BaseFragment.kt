package com.android.oda.appUtilities.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.android.oda.R
import com.android.oda.appUtilities.network.ApiError.*
import com.android.oda.appUtilities.network.ApiResponseWrapper.Failure
import com.android.oda.appUtilities.extensions.setToolbarConfig
import com.android.oda.appUtilities.extensions.showToolbar
import com.android.oda.appUtilities.util.ui.components.toolbar.IconDefinition
import com.android.oda.appUtilities.util.ui.components.toolbar.SimpleToolbarConfig
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass


// Specify the Type parameter and Layout Resource Id
// Will throw an exception if Binding Class and Layout Resource do not match.
typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

open class BaseFragment<M : BaseViewModel, T : ViewBinding>(
    private val fragmentInflate: FragmentInflate<T>,
    @StringRes val title: Int = 0
) : Fragment() {

    val viewModel: M by lazy { getSharedViewModel(viewModelClass()) }
    private var _binding: T? = null
    private lateinit var baseLayout: View
    private lateinit var root: View

    // This can be accessed by the child fragments
    // Only valid between onCreateView and onDestroyView
    val binding: T get() = _binding!!

    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<M> {
        // dirty hack to get generic type https://stackoverflow.com/a/1901275/719212
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<M>).kotlin
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate Method
        _binding = fragmentInflate.invoke(inflater, container, false)
        // Optionally set lifecycle owner if needed
        //binding.lifecycleOwner = viewLifecycleOwner
        // Calling the extension function

        baseLayout = inflater.inflate(R.layout.fragment_base_layout, container, false)
        return baseLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root = view.findViewById(R.id.root)
        view.findViewById<LinearLayout>(R.id.layoutMain).addView(
            binding.root,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
        setupToolbar()
        configureUI()
        configureObservers()
    }

    open fun configureUI() {}
    open fun configureObservers() {}

    override fun onStart() {
        super.onStart()
        viewModel.showProgress.observe(this, {
            it?.let {
                handleProgress(it)
            }
        })
        viewModel.responseError.observe(this, {
            handleFailure(it)
        })
    }

    private fun handleProgress(showProgress: Boolean) {
        if (showProgress) {
            showProgress()
        } else {
            hideProgress()
        }
    }

    // Removing the binding reference when not needed is recommended as it avoids memory leak
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun onBackPress(f: () -> Unit) {
        val callback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                f.invoke()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun showProgress() {
        baseLayout.findViewById<View>(R.id.base_loading_spinner).visibility =
            View.VISIBLE
    }

    private fun hideProgress() {
        baseLayout.findViewById<View>(R.id.base_loading_spinner).visibility =
            View.GONE
    }

    internal fun notify(@StringRes messageId: Int, view: View = root) =
        notify(getString(messageId), view)

    internal fun notify(message: String, view: View = root) =
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()

    internal fun notifyWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        context?.let {
            val snackBar = Snackbar.make(root, message, Snackbar.LENGTH_INDEFINITE)
            snackBar.setAction(actionText) { action.invoke() }
            snackBar.setActionTextColor(ContextCompat.getColor(it, R.color.primary))
            snackBar.show()
        }
    }

    protected open fun handleFailure(failure: Failure) {
        when (failure.apiError) {
            is UnKnownFailure -> {

            }
            is NetworkFailure -> {

            }
            is JsonParseFailure -> {

            }
            is ServerFailure -> {

            }
            is ClientFailure -> {
                
            }
        }
    }


    private fun setupToolbar() {
        if (title != 0) {
            val config = SimpleToolbarConfig(
                IconDefinition.create(R.drawable.ic_navigation_back) { activity?.onBackPressed() },
                getString(title)
            )
            setToolbarConfig(config)
            showToolbar()
        }
    }

}



