package com.milon.retromvvmwithcorouwithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.milon.retromvvmwithcorouwithhilt.databinding.ActivityMainBinding
import com.milon.retromvvmwithcorouwithhilt.viewmodels.MainViewModel
import com.milon.retromvvmwithcorouwithhilt.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel=ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this, Observer {

          binding.products.text=  it.joinToString { x->x.title + "\n\n"  }

        })
    }
}