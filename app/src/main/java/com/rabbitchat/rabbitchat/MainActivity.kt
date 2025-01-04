package com.rabbitchat.rabbitchat

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.rabbitchat.rabbitchat.databinding.ActivityMainBinding
import com.rabbitchat.rabbitchat.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        viewModel.user.observe(this) { user ->
            updateUI(user)
        }
    }

    private fun updateUI(user: User) {
        binding.tvUserStatus.text = "Hi ${user.name}!"
    }
}