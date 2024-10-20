package ru.pokrovskii.design.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

@MainThread
inline fun <reified VM : ViewModel> ViewModelStoreOwner.viewModelFactory(
    noinline factory: () -> VM,
): Lazy<VM> {
    return ViewModelLazy(VM::class, { viewModelStore }, { simpleViewModelFactory(factory) })
}

@MainThread
inline fun <reified VM : ViewModel> ViewModelStore.viewModelFactory(
    noinline factory: () -> VM,
): Lazy<VM> {
    return ViewModelLazy(VM::class, { this }, { simpleViewModelFactory(factory) })
}

inline fun <T : ViewModel> simpleViewModelFactory(crossinline factory: () -> T): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return factory() as T
        }
    }
}