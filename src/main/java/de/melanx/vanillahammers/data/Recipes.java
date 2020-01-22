package de.melanx.vanillahammers.data;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.common.HammerMaterials;
import de.melanx.vanillahammers.common.HammerRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.Tag;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        int i = 0;
        for (RegistryObject<Item> item : HammerRegistry.ITEMS.getEntries()) {
            HammerMaterials hammer = HammerMaterials.values()[i];
            Tag<Item> tagIngredient1 = hammer.getTagIngredient1();
            Tag<Item> tagIngredient2 = hammer.getTagIngredient2();
            ShapedRecipeBuilder recipe = createRecipe(item.get(), tagIngredient1, tagIngredient2);
            recipe.build(consumer);
            i++;
        }
    }

    private ShapedRecipeBuilder createRecipe(Item result, Tag<Item> ingredient1, Tag<Item> ingredient2) {
        if (ingredient2 == null) {
            return createRecipe(result, ingredient1);
        } else {
            return ShapedRecipeBuilder.shapedRecipe(result)
                    .key('d', ingredient1)
                    .key('D', ingredient2)
                    .key('s', Items.STICK)
                    .patternLine("DdD")
                    .patternLine(" s ")
                    .patternLine(" s ")
                    .setGroup(VanillaHammers.MODID)
                    .addCriterion("has_material", hasItem(ingredient1));
        }
    }

    private ShapedRecipeBuilder createRecipe(Item result, Tag<Item> ingredient) {
        return ShapedRecipeBuilder.shapedRecipe(result)
                .key('D', ingredient)
                .key('s', Items.STICK)
                .patternLine("DDD")
                .patternLine("DsD")
                .patternLine(" s ")
                .setGroup(VanillaHammers.MODID)
                .addCriterion("has_material", hasItem(ingredient));
    }
}
