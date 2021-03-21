package com.example.mvvmsample.ui.base
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsample.data.api.ApiHelper
import com.example.mvvmsample.data.repository.MainRepository
import com.example.mvvmsample.ui.main.viewmodel.MainViewModel

class BaseViewModel(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}