package com.example.mayoufcv

import com.example.mayoufcv.data.RemoteDataSource
import com.example.mayoufcv.net.CVService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class RemoteDataSourceTest : BaseTest() {
    private val cvService: CVService = mock()

    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    override fun setup() {
        super.setup()
        remoteDataSource = RemoteDataSource(cvService)
    }

    @Test
    fun testSorting_Ascending() {
        //Given
        whenever(cvService.getCV()).thenReturn(Single.just(getDummyProjects()))

        //When
        val testSubscriber = remoteDataSource.getAllProjects(true).test()

        //Then
        testSubscriber.assertValueCount(1)
        testSubscriber.assertValueAt(0) { it[0].projectId == 1 }
    }

    @Test
    fun testSorting_Descending() {
        //Given
        whenever(cvService.getCV()).thenReturn(Single.just(getDummyProjects()))

        //When
        val testSubscriber = remoteDataSource.getAllProjects(false).test()

        //Then
        testSubscriber.assertValueCount(1)
        testSubscriber.assertValueAt(0) { it[0].projectId == 4 }
    }
}