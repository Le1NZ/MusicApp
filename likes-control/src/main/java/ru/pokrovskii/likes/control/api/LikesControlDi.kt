package ru.pokrovskii.likes.control.api

import org.koin.dsl.module
import ru.pokrovskii.likes.control.impl.EntityLikesInteractorImpl
import ru.pokrovskii.likes.control.impl.SongsLikesInteractorImpl

object LikesControlDi {

    val module = module {
        single<EntityLikesInteractor> { EntityLikesInteractorImpl(get()) }
        single<SongsLikesInteractor> { SongsLikesInteractorImpl(get()) }
    }
}