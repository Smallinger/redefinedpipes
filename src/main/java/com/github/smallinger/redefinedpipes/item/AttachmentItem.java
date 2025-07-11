package com.github.smallinger.redefinedpipes.item;

import com.github.smallinger.redefinedpipes.network.pipe.attachment.AttachmentFactory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class AttachmentItem extends Item {
    private final AttachmentFactory type;

    public AttachmentItem(AttachmentFactory type) {
        super(new Item.Properties());

        this.type = type;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);

        type.addInformation(tooltip);
    }

    public AttachmentFactory getFactory() {
        return type;
    }
} 