package me.chris.headeffects.extensions

import me.chris.headeffects.heads.Head
import me.chris.headeffects.util.HeadRegistry
import org.bukkit.SkullType
import org.bukkit.entity.Player

fun Player.hasEnchantedHead(head: Head) : Boolean {
    val helmet = this.inventory?.helmet ?: return false

    if(helmet.durability != head.skullType.ordinal.toShort()) return false

    val itemMeta = helmet.itemMeta ?: return false

    if(itemMeta.displayName.strippedColor != head.displayName) return false

    var passed = false

    itemMeta.lore.forEach {
        if(it.strippedInvisibility in HeadRegistry.registered) {
            passed = true
        }
    }

    if(!passed) return false

    return true
}

val Player.enchantedHead get() : Head? {
    val helmet = this.inventory?.helmet ?: return null

    val skullOrdinal = SkullType.values().map { it.ordinal.toShort() }

    if(helmet.durability !in skullOrdinal) return null

    val itemMeta = helmet.itemMeta ?: return null

    var passed = false
    var id = ""

    itemMeta.lore.forEach {
        if(it.strippedInvisibility in HeadRegistry.registered) {
            passed = true
            id = it.strippedInvisibility
        }
    }

    if(!passed) return null

    val head = HeadRegistry.registered[id] ?: return null

    return head
}