package com.zdp.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zdp.netlibrary.ApiService
import com.zdp.netlibrary.NetworkManager
import com.zdp.netlibrary.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application).create(UserViewModel::class.java).also {
            it.loadUserInfo("zengdeping")
        }

        userViewModel.nameLiveData.observe(this, Observer {
            tvShowName.text = it.login
        })

    }
}
