package com.milon.retromvvmwithcorouwithhilt

import android.app.Application
import com.milon.retromvvmwithcorouwithhilt.di.ApplicationComponent
import com.milon.retromvvmwithcorouwithhilt.di.DaggerApplicationComponent
import dagger.Component

class FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent= DaggerApplicationComponent.builder().build()

    }
}