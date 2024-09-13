package org.stomspigot

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent
import net.minestom.server.event.server.ServerListPingEvent
import net.minestom.server.instance.block.Block
import org.stomspigot.command.ListPluginsCommand
import org.stomspigot.command.ModeCommand
import org.stomspigot.command.StomSpigotCommand


fun main() {
    val minecraftServer = MinecraftServer.init()
    val instanceManager = MinecraftServer.getInstanceManager();
    val instanceContainer = instanceManager.createInstanceContainer();

    instanceContainer.setGenerator { unit ->
        unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK)
    }

    val globalEventHandler = MinecraftServer.getGlobalEventHandler()
    globalEventHandler.addListener(AsyncPlayerConfigurationEvent::class.java) { event ->
        val player = event.player
        event.spawningInstance = instanceContainer
        player.respawnPoint = Pos(0.0, 42.0, 0.0)
    }

    MinecraftServer.getGlobalEventHandler().addListener(ServerListPingEvent::class.java) { event: ServerListPingEvent ->
        val responseData = event.responseData
        responseData.addEntries(MinecraftServer.getConnectionManager().getOnlinePlayers());

        responseData.setDescription(Component.text("StomSpigot testing", TextColor.color(166, 195, 251)));
        responseData.setVersion("StomSpigot 1.21");

        MinecraftServer.getCommandManager().register(ListPluginsCommand())
        MinecraftServer.getCommandManager().register(StomSpigotCommand())
        MinecraftServer.getCommandManager().register(ModeCommand())
    }

    minecraftServer.start("0.0.0.0", 25565)
}