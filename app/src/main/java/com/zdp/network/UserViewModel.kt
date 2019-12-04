package com.zdp.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zdp.netlibrary.ApiService
import com.zdp.netlibrary.NetworkManager
import com.zdp.netlibrary.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 *
 *created on: 2019-12-04
 *
 *@author:bob.zeng
 *
 */
class UserViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val nameLiveData = MutableLiveData<User>()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun loadUserInfo(name: String) {
        val retrofit = NetworkManager().initRetrofit("https://api.github.com")
        val apiService = retrofit.create(ApiService::class.java)
        uiScope.launch {
            nameLiveData.value = apiService.getUser(name)
        }
    }
}