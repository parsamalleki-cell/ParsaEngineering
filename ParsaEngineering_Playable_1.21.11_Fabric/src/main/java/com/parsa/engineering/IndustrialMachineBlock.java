package com.parsa.engineering;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class IndustrialMachineBlock extends Block {
    private final String machineName;
    private final String description;

    public IndustrialMachineBlock(Properties properties, String machineName, String description) {
        super(properties);
        this.machineName = machineName;
        this.description = description;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                                Player player, BlockHitResult hit) {
        if (!level.isClientSide()) {
            player.displayClientMessage(
                Component.literal("[" + machineName + "] " + description),
                true
            );
        }
        return InteractionResult.SUCCESS;
    }
}
