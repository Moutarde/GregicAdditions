package gregicadditions.jei;

import com.google.common.collect.Lists;
import gregtech.integration.jei.multiblock.MultiblockInfoRecipeWrapper;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.gui.GuiHelper;
import mezz.jei.gui.recipes.RecipeLayout;
import net.minecraft.client.resources.I18n;

public class GAMultiblockInfoCategory implements IRecipeCategory<MultiblockInfoRecipeWrapper> {
    private final IDrawable background;
    private IGuiHelper guiHelper;

    public GAMultiblockInfoCategory(IJeiHelpers helpers) {
        this.background = helpers.getGuiHelper().createBlankDrawable(176, 166);
        this.guiHelper = helpers.getGuiHelper();
    }

    public static void registerRecipes(IModRegistry registry) {
        registry.addRecipes(Lists.newArrayList(
                new MultiblockInfoRecipeWrapper(new CokeOvenInfo()),
                new MultiblockInfoRecipeWrapper(new AssemblyLineInfo()),
                new MultiblockInfoRecipeWrapper(new FusionReactor1Info()),
                new MultiblockInfoRecipeWrapper(new FusionReactor2Info()),
                new MultiblockInfoRecipeWrapper(new FusionReactor3Info())

        ), "gtadditions:multiblock_info");
    }

    public String getUid() {
        return "gtadditions:multiblock_info";
    }

    public String getTitle() {
        return I18n.format("gregtech.multiblock.title", new Object[0]);
    }

    public String getModName() {
        return "gtadditions";
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public void setRecipe(IRecipeLayout recipeLayout, MultiblockInfoRecipeWrapper recipeWrapper, IIngredients ingredients) {
        recipeWrapper.setRecipeLayout((RecipeLayout) recipeLayout, this.guiHelper);
    }
}

