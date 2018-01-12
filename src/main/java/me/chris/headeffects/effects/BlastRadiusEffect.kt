package me.chris.headeffects.effects

import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import java.util.concurrent.ThreadLocalRandom

object BlastRadiusEffect : HeadEffect("Blast Radius") {

    override fun defend(attacker: Entity, holder: Player) {

        val random = ThreadLocalRandom.current().nextInt(1, 5)

        if(random != 3) return

        holder.getNearbyEntities(5.0, 5.0, 5.0).forEach {

            val direction = it.location.toVector().subtract(holder.location.toVector()).add(Vector(0.0, 1.0, 0.0)).normalize()
            direction.multiply(5) //Force
            it.velocity = direction
        }

    }

}