package ru.pokrovskii.auth.di

import org.koin.dsl.module
import ru.pokrovskii.auth.api.UserCenter
import ru.pokrovskii.auth.center.UserCenterImpl
import ru.pokrovskii.auth.storage.UserStorage

object AuthLocalDi {

    val module = module {
        single<UserStorage> { UserStorage(get()) }
        single<UserCenter> { UserCenterImpl(get()) }
    }
}
