package net.casual.championships.uhc

import net.casual.arcade.gui.nametag.ArcadeNameTag
import net.casual.arcade.gui.sidebar.ArcadeSidebar
import net.casual.arcade.gui.sidebar.SidebarComponent
import net.casual.arcade.gui.sidebar.SidebarSupplier
import net.casual.arcade.gui.suppliers.ComponentSupplier
import net.casual.arcade.utils.ComponentUtils
import net.casual.arcade.utils.ComponentUtils.bold
import net.casual.arcade.utils.ComponentUtils.gold
import net.casual.arcade.utils.ComponentUtils.literal
import net.casual.championships.uhc.ui.BorderDistanceRow
import net.casual.championships.uhc.ui.TeammateRow
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation

object UHCUtils {
    fun id(path: String): ResourceLocation {
        return ResourceLocation(UHCMod.ID, path)
    }

    fun createNameTags(): List<ArcadeNameTag> {
        val name = ArcadeNameTag(
            { it.displayName!! },
            { a, _ -> !a.isInvisible }
        )
        val health = ArcadeNameTag(
            { String.format("%.1f ", it.health / 2).literal().append(UHCComponents.ICON_HEART) },
            { a, b -> !a.isInvisible && (b.isSpectator || b.team == a.team) }
        )
        return listOf(health, name)
    }

    fun createSidebar(teamSize: Int): ArcadeSidebar {
        val sidebar = ArcadeSidebar(ComponentSupplier.of(UHCComponents.CASUAL_UHC.gold().bold()))

        val buffer = ComponentUtils.space()
        val teammates = Component.empty().append(buffer).append(UHCComponents.SIDEBAR_TEAMMATES)
        sidebar.addRow(SidebarSupplier.withNoScore(teammates))
        for (i in 0 until teamSize) {
            sidebar.addRow(TeammateRow(i, buffer))
        }
        sidebar.addRow(SidebarSupplier.empty())
        sidebar.addRow(BorderDistanceRow(buffer))
        sidebar.addRow { player ->
            val display = Component.empty().append(buffer).append(UHCComponents.UHC_WB_RADIUS)
            val score = (player.level().worldBorder.size / 2.0).toInt().toString().literal().append(buffer)
            SidebarComponent.withCustomScore(display, score)
        }
        sidebar.addRow(SidebarSupplier.empty())
        return sidebar
    }
}