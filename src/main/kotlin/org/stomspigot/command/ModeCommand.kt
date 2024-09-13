package org.stomspigot.command

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.entity.GameMode
import net.minestom.server.entity.Player


class ModeCommand : Command("mode") {

    init {
        addSubcommand(GodModeSubCommand())
        addSubcommand(SpectatorModeSubCommand())
        addSubcommand(PlayerModeSubCommand())
        addSubcommand(AdventureModeSubCommand())
    }

    private inner class GodModeSubCommand : Command("god") {

        init {
            setDefaultExecutor { sender: CommandSender, context: CommandContext ->
                if (sender is Player) {
                    val player = sender as Player
                        if (player.gameMode == GameMode.CREATIVE) {
                        player.sendMessage((Component.text("God mode activated.", TextColor.color(0x123412))))
                    } else {
                            player.sendMessage((Component.text("God mode disabled.", TextColor.color(0x123412))))
                        }
                } else {
                    sender.sendMessage("for player")
                }
            }
        }
    }


    private inner class PlayerModeSubCommand : Command("player") {

        init {
            setDefaultExecutor { sender: CommandSender, context: CommandContext ->
                if (sender is Player) {
                    val player = sender as Player
                    if (player.gameMode == GameMode.SURVIVAL) {
                        player.sendMessage((Component.text("Player mode activated.", TextColor.color(221, 255, 178))))
                    } else {
                        player.sendMessage((Component.text("Player mode disabled.", TextColor.color(0x123412))))
                    }
                } else {
                    sender.sendMessage("for player")
                }
            }
        }
    }

    private inner class SpectatorModeSubCommand : Command("spectator") {

        init {
            setDefaultExecutor { sender: CommandSender, context: CommandContext ->
                if (sender is Player) {
                    val player = sender as Player
                    if (player.gameMode == GameMode.SPECTATOR) {
                        player.sendMessage((Component.text("Spectator mode activated.", TextColor.color(162, 163, 178))))
                    } else {
                        player.sendMessage((Component.text("Spectator mode disabled.", TextColor.color(0x123412))))
                    }
                } else {
                    sender.sendMessage("for player")
                }
            }
        }
    }

    private inner class AdventureModeSubCommand : Command("adventure") {

        init {
            setDefaultExecutor { sender: CommandSender, context: CommandContext ->
                if (sender is Player) {
                    val player = sender as Player
                    if (player.gameMode == GameMode.SURVIVAL) {
                        player.sendMessage((Component.text("Adventure mode activated.", TextColor.color(221, 255, 178))))
                    } else {
                        player.sendMessage((Component.text("Adventure mode disabled.", TextColor.color(0x123412))))
                    }
                } else {
                    sender.sendMessage("for player")
                }
            }
        }
    }



}
