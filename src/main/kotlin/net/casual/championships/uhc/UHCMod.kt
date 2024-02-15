package net.casual.championships.uhc

import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.fabricmc.loader.api.ModContainer
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object UHCMod: DedicatedServerModInitializer {
    const val ID = "casual_uhc"

    val logger: Logger = LoggerFactory.getLogger("CasualUHC")
    val container: ModContainer = FabricLoader.getInstance().getModContainer(ID).get()

    override fun onInitializeServer() {

    }

    fun id(path: String): ResourceLocation {
        return ResourceLocation(ID, path)
    }
}