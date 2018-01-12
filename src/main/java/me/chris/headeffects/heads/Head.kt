package me.chris.headeffects.heads

import me.chris.headeffects.extensions.colored
import me.chris.headeffects.effects.HeadEffect
import me.chris.headeffects.extensions.invisible
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

abstract class Head(val displayName: String, val identifier: String, val effects: List<HeadEffect>, val skullType: SkullType, val plugin: JavaPlugin) {

    /**
     * Method to give this head to a player
     *
     * @param player player to give this head to.
     */
    fun giveToPlayer(player: Player) {
        val item = ItemStack(Material.SKULL_ITEM, 1)
        val itemMeta = item.itemMeta
        itemMeta.displayName = displayName.colored
        val newLore = mutableListOf<String>()

        newLore.add("&bEffects".colored)
        newLore.add("&f&m----------".colored)
        effects.forEach { newLore.add("&d".colored + it.displayName.colored) }
        newLore.add("&f&m----------".colored)
        newLore.add(identifier.invisible)
        itemMeta.lore = newLore
        item.itemMeta = itemMeta
        item.durability = skullType.ordinal.toShort()

        player.inventory.addItem(item)
    }
}