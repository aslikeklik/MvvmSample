package com.example.mvvmsample.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.data.model.BookModel
import com.example.mvvmsample.data.repository.MainRepository
import com.example.mvvmsample.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val books = MutableLiveData<Resource<List<BookModel>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchBooks()
    }

    private fun fetchBooks() {
        books.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ bookList ->
                    books.postValue(Resource.success(bookList))
                }) {
                    books.postValue(Resource.error("Error Message", null))
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getBooks(): LiveData<Resource<List<BookModel>>> {
        return books
    }

}