package de.melanx.vanillahammers.items;

import de.melanx.morevanillalib.api.BigBreakItem;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraftforge.common.ToolType;

public class HammerItem extends BigBreakItem {
    public HammerItem(IItemTier toolMaterial, float attackSpeed) {
        super(toolMaterial, attackSpeed, ToolUtil.PICKAXE_MATERIALS, ToolType.PICKAXE);
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }
}
