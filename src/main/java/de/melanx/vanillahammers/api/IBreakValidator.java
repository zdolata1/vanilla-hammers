package de.melanx.vanillahammers.api;

import net.minecraft.block.BlockState;

public interface IBreakValidator {

    boolean canBreak(BlockState state);
}
