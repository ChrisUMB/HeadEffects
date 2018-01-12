package me.chris.headeffects.commands

import me.chris.headeffects.util.HeadRegistry
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HeadEffectsCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {

        val player = sender as? Player ?: return true

        if(!player.hasPermission("headeffects.give")) return true

        if(args == null) return false

        if(args.isNotEmpty()) {
            val argument = args[0]

            if(argument == "id") {
                player.sendMessage("All valid ID's")
                player.sendMessage("--------------------")
                HeadRegistry.registered.keys.forEach { player.sendMessage(it) }
                player.sendMessage("--------------------")
                return true
            }

            if(argument != "give" || args.size < 2) {
                player.sendMessage("Unknown command! Proper command is; /headeffects give {id}, and to get id's, do /headeffects id")
                return true
            }

            val id = args[1]

            if(id !in HeadRegistry.registered) {
                player.sendMessage("Unknown head ID! Do /headeffects id to get all the ID's!")
                return true
            }

            val head = HeadRegistry.registered[id] ?: return true
            head.giveToPlayer(player)

        }
        return true
    }
}