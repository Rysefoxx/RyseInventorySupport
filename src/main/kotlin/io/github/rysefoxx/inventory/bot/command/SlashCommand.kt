package io.github.rysefoxx.inventory.bot.command

import net.dv8tion.jda.api.interactions.commands.build.CommandData

abstract class SlashCommand : RespondEvents {

    abstract fun command(): CommandData

}