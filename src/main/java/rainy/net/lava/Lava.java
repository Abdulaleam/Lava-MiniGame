package rainy.net.lava;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rainy.net.lava.item.ModItems;

public class Lava implements ModInitializer {
	public static final String MOD_ID = "lava";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
	}

 }
