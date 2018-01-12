package me.chris.headeffects.effects

import org.bukkit.entity.Entity
import org.bukkit.entity.Player

/**
 * General interface for effects on heads
 * a HeadEffect holds the data that tells the listeners what to do when we're hit or attacking
 *
 * @param displayName the name of this effect, as it will appear on the lore
 */
abstract class HeadEffect(val displayName: String) {

    /**
     * Method called when we hit another entity.
     *
     * @param target the entity that was attacked
     * @param holder the player using a head with this effect
     */
    open fun attack(target: Entity, holder: Player) {}

    /**
     * Method that is called when hit. attacker will be the entity who dealt the damage.
     *
     * @param attacker the entity attacking
     * @param holder the player using a head with this effect
     */
    open fun defend(attacker: Entity, holder: Player) {}

    /**
     * Method called every tick and runs on the holder.
     *
     * @param holder the player using a head with this effect
     */
    open fun update(holder: Player) {}

    /**
     * Method called when a player equips a helmet with this effect.
     *
     * @param holder the player that's equipping a head with this effect
     */
    open fun equip(holder: Player) {}

    /**
     * Method called when a player unequips a helmet with this effect.
     *
     * @param holder the player that's unequipping a head with this effect
     */
    open fun unequip(holder: Player) {}
}