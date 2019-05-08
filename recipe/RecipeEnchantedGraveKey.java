package ovh.corail.tombstone.api.recipe;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

@SuppressWarnings({ "WeakerAccess", "unused" })
public class RecipeEnchantedGraveKey extends ShapelessOreRecipe {
    @ObjectHolder("tombstone:grave_key")
    public static final Item GRAVE_KEY = Items.AIR;

    public RecipeEnchantedGraveKey() {
        // default recipe "tombstone:enchanted_grave_key" as example
        this(null, "enderpearl");
    }

    public RecipeEnchantedGraveKey(@Nullable ResourceLocation group, Object... ingredients) {
        super(group, setEnchant(new ItemStack(GRAVE_KEY), false), ingredients);
        getIngredients().add(Ingredient.fromStacks(new ItemStack(GRAVE_KEY)));
    }

    public RecipeEnchantedGraveKey(@Nullable ResourceLocation group, NonNullList<Ingredient> ingredients) {
        super(group, ingredients, setEnchant(new ItemStack(GRAVE_KEY), false));
        getIngredients().add(Ingredient.fromStacks(new ItemStack(GRAVE_KEY)));
    }

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        return GRAVE_KEY != Items.AIR && super.matches(inv, world);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return IntStream.range(0, inv.getSizeInventory()).mapToObj(inv::getStackInSlot).filter(stack -> stack.getItem() == GRAVE_KEY).findFirst().map(stack -> setEnchant(stack.copy(), true)).orElse(ItemStack.EMPTY);
    }

    /**
     * This method only exists to imitate what is done when a key is enchanted
     *
     * @param key a key not yet enchanted
     * @return the result of this recipe, an enchanted key
     */
    public static ItemStack setEnchant(ItemStack key, boolean checkCompound) {
        if (key.getItem() == GRAVE_KEY) {
            NBTTagCompound nbt = key.getTagCompound();
            if (nbt == null) {
                if (checkCompound) {
                    return ItemStack.EMPTY; // a key should always have a compound
                }
                nbt = new NBTTagCompound();
                key.setTagCompound(nbt);
            }
            if (checkCompound && nbt.hasKey("enchant", Constants.NBT.TAG_BYTE) && nbt.getBoolean("enchant")) {
                return ItemStack.EMPTY; // the key is already enchanted
            }
            nbt.setBoolean("enchant", true);
        }
        return key;
    }
}
