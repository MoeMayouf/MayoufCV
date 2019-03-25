package com.example.mayoufcv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.data.Project
import com.example.mayoufcv.screen.home.HomeViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest : BaseTest() {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository: DataSource = mock()

    private val observer: Observer<List<Project>> = mock()

    private val projects = getDummyProjects()


    private lateinit var homeViewModel: HomeViewModel

    @Before
    override fun setup() {
        super.setup()
        homeViewModel = HomeViewModel(repository)
    }

    @Test
    fun test_Data_Successfully_Retrieved() {
        //Given
        whenever(repository.getAllProjects(anyBoolean())).thenReturn(Maybe.just(projects))
        homeViewModel.getResultsObservable().observeForever(observer)
        //When
        homeViewModel.getResults()

        //Then
        verify(observer, times(1)).onChanged(projects)
    }
}