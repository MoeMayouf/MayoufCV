package com.example.mayoufcv

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.mayoufcv.data.Project
import com.example.mayoufcv.database.AppDatabase
import com.example.mayoufcv.database.CVDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    private val COMPANY_NAME_ONE = "Acme"
    private val COMPANY_NAME_TWO = "Umbrella Corp"

    private lateinit var cvDao: CVDao

    private lateinit var appDatabase: AppDatabase

    @Before
    fun setup() {
        appDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java).build()
        cvDao = appDatabase.getCVDao()
    }

    @Test
    fun testDatabase_ReadAndWrite() {
        //Given
        val projectOne = Project(projectId = 1, company = COMPANY_NAME_ONE)
        val projectTwo = Project(projectId = 2, company = COMPANY_NAME_TWO)
        cvDao.addProject(projectOne)
        cvDao.addProject(projectTwo)

        //When
        val testObserver = cvDao.getAllProjectsAscending().test()

        //Then
        testObserver.assertValueAt(0) { it[0].company == COMPANY_NAME_ONE }

        //And When
        val testObserverDescending = cvDao.getAllProjectsDescending().test()

        //And Then
        testObserverDescending.assertValueAt(0) { it[0].company == COMPANY_NAME_TWO }
    }


    @After
    fun tearDown() {
        appDatabase.close()
    }
}
