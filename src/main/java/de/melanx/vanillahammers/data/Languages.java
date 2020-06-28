package de.melanx.vanillahammers.data;

import de.melanx.morevanillalib.api.BigBreakItem;
import de.melanx.morevanillalib.api.BigBreakMaterials;
import de.melanx.morevanillalib.util.TranslationHelper;
import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.items.HammerRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class Languages {

    public static class English extends LanguageProvider {
        public English(DataGenerator generator) {
            super(generator, VanillaHammers.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            for (RegistryObject<Item> object : HammerRegistry.ITEMS.getEntries()) {
                Item item = object.get();
                String material = ((BigBreakMaterials) ((BigBreakItem) item).getToolMaterial()).getPrefix();
                add(item, TranslationHelper.capitalize(material) + " Hammer");
            }
        }
    }

    public static class German extends LanguageProvider {
        public German(DataGenerator generator) {
            super(generator, VanillaHammers.MODID, "de_de");
        }

        @Override
        protected void addTranslations() {
            for (RegistryObject<Item> object : HammerRegistry.ITEMS.getEntries()) {
                Item item = object.get();
                String path = item.getRegistryName().getPath();
                add(item, TranslationHelper.getGermanMaterial(path) + "hammer");
            }
        }
    }

}
