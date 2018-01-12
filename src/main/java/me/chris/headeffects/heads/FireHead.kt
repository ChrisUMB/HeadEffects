package me.chris.headeffects.heads

import me.chris.headeffects.HeadEffects
import me.chris.headeffects.effects.FireEffect
import org.bukkit.SkullType

object FireHead : Head("Fire Head", "HEADEFFECTS_FIRE_HEAD", listOf(FireEffect), SkullType.CREEPER, HeadEffects.plugin)