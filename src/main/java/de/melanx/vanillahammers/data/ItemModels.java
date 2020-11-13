package de.melanx.vanillahammers.data;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.items.HammerRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemModels extends de.melanx.morevanillalib.data.ItemModels {
    public ItemModels(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, VanillaHammers.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : HammerRegistry.ITEMS.getEntries())
            this.generateItem(item.get());
    }

    @Override
    public String getName() {
        return VanillaHammers.MODID + " item models";
    }
}
