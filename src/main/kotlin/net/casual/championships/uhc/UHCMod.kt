package net.casual.championships.uhc

import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.fabricmc.loader.api.ModContainer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UHCMod: DedicatedServerModInitializer {
    companion object {
        const val ID = "uhc"

        val logger: Logger = LoggerFactory.getLogger("Uhc")
        val container: ModContainer = FabricLoader.getInstance().getModContainer(ID).get()
    }

    override fun onInitializeServer() {
        TODO("Not yet implemented")
    }
}