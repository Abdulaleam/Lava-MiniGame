package rainy.net.lava;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rainy.net.lava.item.ModItems;

public class Lava implements ModInitializer {
	public static final String MOD_ID = "lava";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
         ModServerTick.register();
		ModItems.registerModItems();
	}
	public class ModServerTick {

		public static void register() {

			ServerTickEvents.END_SERVER_TICK.register(server -> {

				for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

					LavaStartAbility.tick(player, player.getWorld());
				}
			});

 }}}
