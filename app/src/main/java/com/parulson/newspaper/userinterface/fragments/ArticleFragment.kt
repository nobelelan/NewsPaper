package com.parulson.newspaper.userinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.parulson.newspaper.databinding.FragmentArticleBinding
import com.parulson.newspaper.databinding.FragmentSearchNewsBinding
import com.parulson.newspaper.userinterface.BindingFragment
import com.parulson.newspaper.userinterface.NewsActivity
import com.parulson.newspaper.userinterface.NewsViewModel


class ArticleFragment : BindingFragment<FragmentArticleBinding>() {

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentArticleBinding::inflate

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel

        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient( )
            article.url?.let { loadUrl(it) }
        }

        binding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}