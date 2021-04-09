package com.moviles.homework.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.moviles.homework.R
import com.moviles.homework.intent.Intent
import com.moviles.homework.ui.MainViewModel
import com.moviles.homework.utils.Adapter
import com.moviles.homework.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
) : Fragment(R.layout.fragment_first) {

    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var dogAdapter: Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
//        viewModel.setStateEvent()
        val layoutManager =
            LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        rv.layoutManager = layoutManager
        rv.adapter = dogAdapter

        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetDogEvent)
        }
    }

    private fun subscribeObservers() {
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when (it) {
                    is DataState.Success -> {
                        displayProgressBar(false)
//                    appendDogID(dataState.data)
                        dogAdapter.setImg(it.dogs)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        //  if (message != null) text.text = message else text.text = "Unknown error."
    }


    private fun displayProgressBar(isDisplayed: Boolean) {
        progress.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

}