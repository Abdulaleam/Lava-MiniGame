package rainy.net.lava;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LavaStartAbility {

    private static final Set<UUID> ACTIVE = new HashSet<>();
    private static int ticks = 0;

    public static void toggleStart(ServerPlayerEntity player) {
        ACTIVE.add(player.getUuid());
    }

    public static void toggleStop(ServerPlayerEntity player) {
        ACTIVE.remove(player.getUuid());
    }

    public static boolean isActive(ServerPlayerEntity player) {
        return ACTIVE.contains(player.getUuid());
    }

    public static void tick(ServerPlayerEntity player, World world) {

        if (!isActive(player))
        {return;}

        ticks++;

        BlockPos center = player.getBlockPos();
        if (ticks % 15 == 0) {

            int x = center.getX() + (int)(Math.random() * 18) - 9;
            int z = center.getZ() + (int)(Math.random() * 18) - 9;

            for (int y = 255; y >= 0; y--) {

                BlockPos pos = new BlockPos(x, y, z);

                if (!world.getBlockState(pos).isAir()) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
            }
        }

        if (ticks % 25 == 0) {

            int x = center.getX() + (int)(Math.random() * 18) - 9;
            int z = center.getZ() + (int)(Math.random() * 18) - 9;

            BlockPos pos = new BlockPos(x, center.getY(), z);

            if (world.getBlockState(pos).isAir()) {
                world.setBlockState(pos, Blocks.LAVA.getDefaultState());
            }
        }

        if (ticks >= 100000)
        {ticks = 0;}
    }
}