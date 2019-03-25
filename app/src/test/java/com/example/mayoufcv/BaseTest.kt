package com.example.mayoufcv

import com.example.mayoufcv.data.Project
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
open class BaseTest {
    private val scheduler = object : Scheduler() {
        override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
            return super.scheduleDirect(run, 0, unit)
        }
        override fun createWorker(): Scheduler.Worker {
            return ExecutorScheduler.ExecutorWorker(
                Executor { it.run() }, false)
        }
    }

    @Before
    open fun setup() {
        RxJavaPlugins.setInitIoSchedulerHandler { scheduler }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler }
    }

    fun getDummyProjects(): List<Project> {
        return listOf(Project(projectId = 1),
                        Project(projectId = 2),
                        Project(projectId = 3),
                        Project(projectId = 4))
    }
}