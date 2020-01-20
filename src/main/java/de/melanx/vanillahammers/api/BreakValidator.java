package de.melanx.vanillahammers.api;

import net.minecraft.block.BlockState;

public interface BreakValidator {

    boolean canBreak(BlockState state);
}
