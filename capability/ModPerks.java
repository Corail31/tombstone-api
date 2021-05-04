package ovh.corail.tombstone.api.capability;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder("tombstone")
public class ModPerks {
    public static final Perk ghostly_shape = new DummyPerk();
    public static final Perk voodoo_poppet = new DummyPerk();
    public static final Perk scribe = new DummyPerk();
    public static final Perk rune_inscriber = new DummyPerk();
    public static final Perk treasure_seeker = new DummyPerk();
    public static final Perk jailer = new DummyPerk();
    public static final Perk bone_collector = new DummyPerk();
    public static final Perk memento_mori = new DummyPerk();
    public static final Perk disenchanter = new DummyPerk();
    public static final Perk alchemist = new DummyPerk();
}
