package rainy.net.lava;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LavaStartItem extends Item {

    public LavaStartItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, net.minecraft.entity.player.PlayerEntity user, Hand hand) {

        if (!world.isClient && user instanceof ServerPlayerEntity player) {
            rainy.net.lava.LavaStartAbility.toggleStart(player);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}