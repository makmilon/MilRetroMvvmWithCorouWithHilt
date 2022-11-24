package com.milon.retromvvmwithcorouwithhilt.di

import com.milon.retromvvmwithcorouwithhilt.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

     fun inject(mainActivity: MainActivity)
}