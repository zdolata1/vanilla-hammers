package com.github.draylar.vh.api;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends PickaxeItem {
    public HammerItem(IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        this(toolMaterial, attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
    }

    public HammerItem(IItemTier toolMaterial, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (player.isSneaking()) {
            return true;
        }

        float originHardness = world.getBlockState(pos).getBlockHardness(null, null);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getHeldItemMainhand().canHarvestBlock(world.getBlockState(pos))) {
            BlockBreaker.breakInRadius(world, player, 1, (breakState) -> {
                double hardness = breakState.getBlockHardness(null, null);
                boolean isEffective = player.getHeldItemMainhand().canHarvestBlock(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            }, true);
        }

        return true;
    }
}

