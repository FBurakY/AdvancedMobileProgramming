package com.fburaky.hiltkotlin

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton

interface MyInterface {
    fun myPrintFunction() : String
}
/*
// 1. Yöntem @Binds
@InstallIn(ActivityComponent::class)
@Module
abstract class MyModule{
    @ActivityScoped
    @Binds
    abstract fun bindingFunction(myImplementor : InterfaceImplementer) : MyInterface
}
 */

@InstallIn(ApplicationComponent::class)
@Module
class  MyModule{
    @FirstImplementor
    @Singleton
    @Provides
    fun providerFunction() : MyInterface{
        return InterfaceImplementer()
    }

    @SecondImplementor
    @Singleton
    @Provides
    fun secondProviderFunction() : MyInterface{
        return SecondInterfaceImplementor()
    }


    @Singleton
    @Provides
    fun gSonProvider() : Gson{
        return Gson()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirstImplementor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondImplementor