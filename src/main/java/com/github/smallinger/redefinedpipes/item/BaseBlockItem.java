package com.github.smallinger.redefinedpipes.item;

import com.github.smallinger.redefinedpipes.RedefinedPipes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BaseBlockItem extends BlockItem {
    public BaseBlockItem(Block block) {
        super(block, new Item.Properties());
    }
} 