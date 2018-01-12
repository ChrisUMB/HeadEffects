package me.chris.headeffects

import me.chris.headeffects.commands.HeadEffectsCommand
import me.chris.headeffects.heads.FireHead
import me.chris.headeffects.heads.GodHead
import me.chris.headeffects.listeners.EntityDamageByEntityListener
import me.chris.headeffects.util.HeadRegistry
import me.chris.headeffects.util.Checks
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class HeadEffects : JavaPlugin() {

    override fun onEnable() {
        registerCommands()
        registerListeners()
        referenceHeads()
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, {
            Checks.runUpdateCheck()
            Checks.runEquipUnequipCheck()
        }, 1, 1)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun registerCommands() {
        getCommand("headeffects").executor = HeadEffectsCommand()
    }

    private fun registerListeners() {
        fun Listener.register() = Bukkit.getServer().pluginManager.registerEvents(this, this@HeadEffects)

        EntityDamageByEntityListener.register()

    }

    private fun referenceHeads() {
        HeadRegistry.register(FireHead)
        HeadRegistry.register(GodHead)
    }

    companion object {
        val plugin by lazy { JavaPlugin.getPlugin(HeadEffects::class.java) }
    }

}
