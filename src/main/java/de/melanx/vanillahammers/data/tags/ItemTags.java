package de.melanx.vanillahammers.data.tags;

import de.melanx.morevanillalib.api.BigBreakItem;
import de.melanx.morevanillalib.api.BigBreakMaterials;
import de.melanx.morevanillalib.data.ModTags;
import de.melanx.vanillahammers.items.HammerRegistry;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ItemTags extends ItemTagsProvider {

    public ItemTags(DataGenerator generator, BlockTagsProvider blockTags) {
        super(generator, blockTags);
    }

    @Override
    protected void registerTags() {
        for (RegistryObject<Item> registryObject : HammerRegistry.ITEMS.getEntries()) {
            Item item = registryObject.get();
            BigBreakMaterials itemTier = (BigBreakMaterials) ((BigBreakItem) item).getToolMaterial();
            switch (itemTier) {
                case WOOD:
                    getOrCreateBuilder(ModTags.Items.WOOD_TOOLS).add(item);
                    break;
                case STONE:
                    getOrCreateBuilder(ModTags.Items.STONE_TOOLS).add(item);
                    break;
                case IRON:
                    getOrCreateBuilder(ModTags.Items.IRON_TOOLS).add(item);
                    break;
                case GOLD:
                    getOrCreateBuilder(ModTags.Items.GOLD_TOOLS).add(item);
                    break;
                case DIAMOND:
                    getOrCreateBuilder(ModTags.Items.DIAMOND_TOOLS).add(item);
                    break;
                case NETHERITE:
                    getOrCreateBuilder(ModTags.Items.NETHERITE_TOOLS).add(item);
                    break;
            }
        }
    }
}
