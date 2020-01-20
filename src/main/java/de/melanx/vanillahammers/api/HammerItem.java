package de.melanx.vanillahammers.api;

import de.melanx.vanillahammers.common.HammerMaterials;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends PickaxeItem {
    private IItemTier toolMaterial;

    public HammerItem(IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
        this.toolMaterial = toolMaterial;
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

    @Override
    public void onCreated(ItemStack stack, World world, PlayerEntity player) {
        if (this.getToolMaterial() == HammerMaterials.SLIME)
            stack.addEnchantment(Enchantments.KNOCKBACK, 3);
    }

    public IItemTier getToolMaterial() {
        return toolMaterial;
    }
}

