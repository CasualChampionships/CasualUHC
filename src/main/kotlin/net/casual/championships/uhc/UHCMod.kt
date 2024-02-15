package net.casual.championships.uhc

import eu.pb4.polymer.resourcepack.api.ResourcePackCreator
import net.casual.arcade.utils.ComponentUtils.literal
import net.casual.arcade.utils.ResourcePackUtils.addLangsFromData
import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.fabricmc.loader.api.ModContainer
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object UHCMod: DedicatedServerModInitializer {
    const val MOD_ID = "casual_uhc"

    val logger: Logger = LoggerFactory.getLogger("CasualUHC")

    val UHC_PACK_CREATOR: ResourcePackCreator = ResourcePackCreator.create()

    init {
        UHC_PACK_CREATOR.apply {
            addAssetSource(MOD_ID)
            addLangsFromData(MOD_ID)
            packDescription = "Resources for CasualChampionships UHC minigame".literal()
        }
    }

    override fun onInitializeServer() {

    }

    fun id(path: String): ResourceLocation {
        return ResourceLocation(MOD_ID, path)
    }
}