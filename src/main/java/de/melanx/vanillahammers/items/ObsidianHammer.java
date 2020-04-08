package de.melanx.vanillahammers.items;

import de.melanx.morevanillalib.api.BigBreakItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class ObsidianHammer extends BigBreakItem {

    public ObsidianHammer(IItemTier toolMaterial, float attackSpeed) {
        super(toolMaterial, attackSpeed);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock() == Blocks.OBSIDIAN) {
            int efficiencyLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, stack);
            return 5.0F * (efficiencyLevel / 3.5F + 1);
        } else {
            return super.getDestroySpeed(stack, state);
        }
    }
}
