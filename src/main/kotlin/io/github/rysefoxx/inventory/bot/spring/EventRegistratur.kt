package io.github.rysefoxx.inventory.bot.spring

import io.github.rysefoxx.inventory.bot.Bootstrap
import io.github.rysefoxx.inventory.bot.log.Logger
import io.github.rysefoxx.inventory.bot.spring.event.DiscordApplicationReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.context.event.EventListener
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
class EventRegistratur {

    @EventListener(DiscordApplicationReadyEvent::class)
    @Order(2)
    fun registerEvents() {
        Logger.info("Trying to register all events.")
        Bootstrap.context.getBeansOfType(ListenerAdapter::class.java).values.forEach {
            Logger.info("Registered event [${it.javaClass.simpleName}]")
            Bootstrap.jda.addEventListener(it)
        }
    }

}