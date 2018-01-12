package me.chris.headeffects.heads

import me.chris.headeffects.HeadEffects
import me.chris.headeffects.effects.BlastRadiusEffect
import me.chris.headeffects.effects.FireEffect
import me.chris.headeffects.effects.LightningEffect
import me.chris.headeffects.effects.SpeedEffect
import org.bukkit.SkullType

object GodHead : Head("God Head", "HEADEFFECTS_GOD_HEAD", listOf(FireEffect, LightningEffect, BlastRadiusEffect, SpeedEffect), SkullType.SKELETON, HeadEffects.plugin)