package net.casual.championships.uhc.ui

import net.casual.arcade.gui.bossbar.CustomBossBar
import net.casual.arcade.minigame.Minigame
import net.casual.arcade.stats.ArcadeStats
import net.casual.arcade.utils.ComponentUtils.literal
import net.casual.arcade.utils.TimeUtils
import net.casual.arcade.utils.TimeUtils.Ticks
import net.casual.arcade.utils.TimeUtils.formatHHMMSS
import net.casual.championships.util.Texts
import net.casual.championships.util.Texts.shadowless
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.BossEvent

class ActiveBossBar(
    private val owner: Minigame<*>
): CustomBossBar() {
    override fun getTitle(player: ServerPlayer): Component {
        val start = Component.empty()
            .append(Texts.space(-2))
            .append(Texts.ICON_SHORT_BACKGROUND.shadowless())
            .append(Texts.space(-27))
            .append("%02d".format(this.owner.getPlayingPlayers().size).literal())
            .append(Texts.ICON_PLAYERS)
            .append(Texts.space(42))
            .append(Texts.space(1, 2))
        val end = Component.empty()
            .append(Texts.space(39))
            .append(Texts.ICON_SHORT_BACKGROUND.shadowless())
            .append(Texts.space(-27))
            .append("%02d".format(this.owner.stats.getOrCreateStat(player, ArcadeStats.KILLS).value).literal())
            .append(Texts.ICON_KILLS)
        val middle = Texts.BOSSBAR_ELAPSED.generate(this.owner.uptime.Ticks.formatHHMMSS())
        return start.append(middle).append(end)
    }

    override fun getProgress(player: ServerPlayer): Float {
        return 1.0F
    }

    override fun getColour(player: ServerPlayer): BossEvent.BossBarColor {
        return BossEvent.BossBarColor.YELLOW
    }

    override fun getOverlay(player: ServerPlayer): BossEvent.BossBarOverlay {
        return BossEvent.BossBarOverlay.PROGRESS
    }
}