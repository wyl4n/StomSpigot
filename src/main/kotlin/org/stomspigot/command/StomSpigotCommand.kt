package org.stomspigot.command

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext

class StomSpigotCommand : Command("stomspigot") {

    init {
        setDefaultExecutor { sender: CommandSender, context: CommandContext ->
                sender.sendMessage((Component.text("You are using version 0.1x of StomSpigot.", TextColor.color(166, 195, 251))))
            }
    }
}
