package rainy.net.lava.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.net.lava.Lava;
import rainy.net.lava.LavaStartItem;
import rainy.net.lava.LavaStopItem;

public class ModItems {

    public static final Item START = registerItem("start", new LavaStartItem(new Item.Settings()));

    public static final Item STOP = registerItem("stop", new LavaStopItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Lava.MOD_ID, name), item);
    }


    public static void registerModItems() {


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.add(START);
            entries.add(STOP);


        });




    }





}

