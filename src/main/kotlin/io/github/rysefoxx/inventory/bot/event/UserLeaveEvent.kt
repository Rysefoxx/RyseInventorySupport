package io.github.rysefoxx.inventory.bot.event

import io.github.rysefoxx.inventory.bot.log.Logger
import io.github.rysefoxx.inventory.bot.model.entity.UserEntity
import io.github.rysefoxx.inventory.bot.model.service.UserService
import net.dv8tion.jda.api.events.guild.GuildJoinEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserLeaveEvent(

    @Autowired
    val userService: UserService

) : ListenerAdapter() {

    override fun onGuildMemberRemove(event: GuildMemberRemoveEvent) {
        Logger.info("User leave: " + event.user.id)
        val id = event.member?.idLong ?: event.user.idLong

        userService.deleteUser(id)
    }
}