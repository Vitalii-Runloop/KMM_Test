package com.example.helloworld_kmm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.helloworld.Greeting
import com.example.helloworld.Repository
import com.example.helloworld_kmm.R
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val textView = this.view?.findViewById<TextView>(R.id.message)
        var greeting: String = Greeting().greeting()
        textView?.text = greeting

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.placeholder.collect { placeholder ->
                    val text = greeting + "\n\n" +
                            "ID: " + placeholder?.id.toString() + "\n" +
                            "UserID: " + placeholder?.userId.toString() + "\n" +
                            "Title: " + placeholder?.title + "\n" +
                            "Completed: " + placeholder?.completed.toString()
                    textView?.text = text
                }
            }
        }
    }

}