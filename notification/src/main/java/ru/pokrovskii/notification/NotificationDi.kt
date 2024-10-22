package ru.pokrovskii.notification

import org.koin.dsl.module
import ru.pokrovskii.notification.api.NotificationController
import ru.pokrovskii.notification.impl.NotificationControllerImpl

object NotificationDi {

    val module = module {
        single<NotificationController> { NotificationControllerImpl(get()) }
    }
}