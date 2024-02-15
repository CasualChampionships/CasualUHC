package net.casual.championships.uhc.resources

import net.casual.arcade.minigame.MinigameResources
import net.casual.arcade.resources.PackInfo

object UHCResources: MinigameResources {
    override fun getPacks(): Collection<PackInfo> {
        // TODO:
        // val pack = CasualResourcePackHost.getHostedPack("casual-pack")?.toPackInfo(!Config.dev, Texts.PACK_MESSAGE)
        // return listOf(pack ?: return super.getPacks())
        return listOf()
    }
}