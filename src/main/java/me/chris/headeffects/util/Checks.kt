package me.chris.headeffects.util

import me.chris.headeffects.extensions.enchantedHead
import me.chris.headeffects.heads.Head
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object Checks {

    private val equipped = mutableMapOf<Player, Head?>()

    fun runEquipUnequipCheck() {

        Bukkit.getOnlinePlayers().forEach { player ->
            val previous = equipped[player]
            val current = player.enchantedHead

            if(current != previous) {
                previous?.effects?.forEach { it.unequip(player) }
                current?.effects?.forEach { it.equip(player) }
            }

            equipped[player] = current
        }
    }

    fun runUpdateCheck() {
        Bukkit.getOnlinePlayers().filter { it.enchantedHead != null }.forEach { player ->
            player.enchantedHead?.effects?.forEach { it.update(player) }
        }
    }
}