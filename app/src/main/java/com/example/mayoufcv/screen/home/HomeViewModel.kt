package com.example.mayoufcv.screen.home

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.data.Project
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val repository: DataSource) : ViewModel() {
    private val resultsObservable = MutableLiveData<List<Project>>()
    private val progressObservable = ObservableBoolean(false)
    private val compositeDisposable = CompositeDisposable()

    fun getResultsObservable(): LiveData<List<Project>> = resultsObservable

    fun getProgressObservable() = progressObservable

    fun getResults(isAscending: Boolean = false) {
        compositeDisposable.add(repository.getAllProjects(isAscending)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progressObservable.set(true) }
            .doOnEvent { _, _ -> progressObservable.set(false)  }
            .subscribe({ resultsObservable.value = it }, { it.printStackTrace() }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}