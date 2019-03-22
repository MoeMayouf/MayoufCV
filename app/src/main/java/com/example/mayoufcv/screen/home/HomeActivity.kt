package com.example.mayoufcv.screen.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mayoufcv.R
import com.example.mayoufcv.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val projectsAdapter = ProjectsAdapter()
        rvProjects.layoutManager = LinearLayoutManager(this)
        rvProjects.adapter = projectsAdapter

        activityMainBinding.progressVisibility = homeViewModel.getProgressObservable()
        homeViewModel.getResultsObservable().observe(this, Observer { projectsAdapter.setData(it) })
        homeViewModel.getResults()
    }
}
