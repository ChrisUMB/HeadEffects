package me.chris.headeffects.listeners

import me.chris.headeffects.extensions.enchantedHead
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

object EntityDamageByEntityListener : Listener {

    @EventHandler
    fun EntityDamageByEntityEvent.onEntityDamageEntity() {
        val attacker = this.damager
        val attacked = this.entity

        if(attacked is Player) {
            val head = attacked.player.enchantedHead
            head?.effects?.forEach { it.defend(attacker, attacked) }
        }

        if(attacker is Player) {
            val head = attacker.player.enchantedHead
            head?.effects?.forEach { it.attack(attacked, attacker) }
        }
    }
}