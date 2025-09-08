package com.elyisus14.voidtools.Food;

import com.elyisus14.voidtools.VoidTools;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VoidCarrot extends Item {

    public VoidCarrot(Properties properties) {
        super(properties);

    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

        if((entityLiving instanceof Player) && (stack.getItem() == VoidTools.VOID_CARROT.get())) {
            Player player = (Player)entityLiving;
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,36000,9,false,true));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,36000,9,false,true));

        }
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
