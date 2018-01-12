package me.chris.headeffects.effects

import org.bukkit.entity.Entity
import org.bukkit.entity.Player

object LightningEffect : HeadEffect("Lightning Strike") {
    override fun attack(target: Entity, holder: Player) {

        holder.world.strikeLightning(target.location)

    }
}