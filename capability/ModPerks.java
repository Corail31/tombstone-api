package ovh.corail.tombstone.api.capability;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder("tombstone")
public class ModPerks {
    public static final Perk ghostly_shape = new DummyPerk();
    public static final Perk voodoo_poppet = new DummyPerk();
    public static final Perk mastery_of_scrolls = new DummyPerk();
    public static final Perk mastery_of_tablets = new DummyPerk();
    public static final Perk lost_tablet = new DummyPerk();
    public static final Perk grave_key = new DummyPerk();
    public static final Perk bone_collector = new DummyPerk();
    public static final Perk memento_mori = new DummyPerk();
    public static final Perk disenchantment = new DummyPerk();
}
