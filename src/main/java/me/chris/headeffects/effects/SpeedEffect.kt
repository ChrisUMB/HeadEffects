package me.chris.headeffects.effects

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object SpeedEffect : HeadEffect("&bSpeed") {
    override fun equip(holder: Player) {
        holder.addPotionEffect(PotionEffect(PotionEffectType.SPEED, Int.MAX_VALUE, 2, false, false))
    }

    override fun unequip(holder: Player) {
        holder.removePotionEffect(PotionEffectType.SPEED)
    }
}