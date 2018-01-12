package me.chris.headeffects.effects

import org.bukkit.entity.Entity
import org.bukkit.entity.Player

object FireEffect : HeadEffect("Ignite") {

    override fun attack(target: Entity, holder: Player) {
        target.fireTicks += 10
    }
}