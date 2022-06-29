package com.example.helloworld_kmm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.helloworld.Greeting
import com.example.helloworld_kmm.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
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
        // TODO: Use the ViewModel

        val textView = this.view?.findViewById<TextView>(R.id.message)
        var greeting: String = Greeting().greeting()
        textView?.text = greeting

        GlobalScope.launch {
            viewModel.loadPlaceholder()
            val placeholder = viewModel.placeholder
            GlobalScope.launch(Dispatchers.Main) {
                textView?.text = greeting + "\n\n" +
                        "ID: " + placeholder.id.toString() + "\n" +
                        "UserID: " + placeholder.userId.toString() + "\n" +
                        "Title: " + placeholder.title + "\n" +
                        "Completed: " + placeholder.completed.toString()
            }
        }
    }

}