package org.stomspigot.command

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.minestom.server.MinecraftServer
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.entity.Player

class ListPluginsCommand : Command("pl") {

    init {
        setDefaultExecutor { sender: CommandSender, context: CommandContext ->
            if (sender is Player) {
                val plugins = MinecraftServer.getCommandManager().commands
                val pluginList = plugins.joinToString(separator = ", ") { it.name }
                sender.sendMessage((Component.text("Plugins: " + pluginList, TextColor.color(221, 255, 178))))
            } else {
                sender.sendMessage("Este comando só pode ser executado por um jogador.")
            }
        }
    }
}
