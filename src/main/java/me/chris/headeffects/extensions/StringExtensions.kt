package me.chris.headeffects.extensions

import org.bukkit.ChatColor

val String.colored get() : String {
    return ChatColor.translateAlternateColorCodes('&', this)
}

val String.strippedColor get() : String {
    return ChatColor.stripColor(this)
}

val String.strippedInvisibility get() : String {
    return this.replace("\u00a7", "")
}

val String.invisible get() : String {
    var hidden = ""
    this.toCharArray().forEach { hidden += "${ChatColor.COLOR_CHAR}$it"}
    return hidden
}