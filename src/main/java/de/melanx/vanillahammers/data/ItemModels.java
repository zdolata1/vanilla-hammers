package de.melanx.vanillahammers.data;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.common.HammerRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.fml.RegistryObject;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, VanillaHammers.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : HammerRegistry.ITEMS.getEntries())
            generateItem(item.get());
    }

    private void generateItem(Item item) {
        String path = item.getRegistryName().getPath();
        getBuilder(path).parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + path);
    }

    @Override
    public String getName() {
        return VanillaHammers.MODID + " item models";
    }
}
