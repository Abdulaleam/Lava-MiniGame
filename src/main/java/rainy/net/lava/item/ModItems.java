package rainy.net.lava.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.net.lava.Lava;

public class ModItems {

    public static Item START = registerItem("start", new Item(new Item.Settings()));

    public static Item STOP = registerItem("stop", new Item(new Item.Settings()));


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

