package me.chris.headeffects.util

import com.sun.xml.internal.txw2.IllegalSignatureException
import me.chris.headeffects.heads.Head

object HeadRegistry {
    /**
     * Field responsible for keeping track of all registered heads.
     */
    private val registry = mutableMapOf<String, Head>()

    /**
     * Property responsible for external obtaining of the registry.
     */
    val registered get() : Map<String, Head> {
        return registry
    }

    /**
     * Method responsible for adding to the registry and maintaining no duplicate identifiers.
     *
     * @param head the head to add to the registry.
     */
    fun register(head: Head) {
        if(head.identifier in registry)
            throw IllegalSignatureException("Cannot register a head more than once! Registered twice: '${head.displayName}' with identifier '${head.identifier}'")
        registry.put(head.identifier, head)
        println("HeadEffects (registry) -> REGISTERED HEAD ID '${head.identifier}' TO PLUGIN '${head.plugin.name}' SUCCESSFULLY")
    }
}