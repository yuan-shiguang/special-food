package com.yuanshiguang.specialfood;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(modid = "specialfood", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    // 混凝土意大利面
    public static final Item CONCRETE_SPAGHETTI = new Item(
        new Item.Properties()
            .tab(SpecialFood.SPECIAL_FOOD_TAB)
            .food(Foods.CONCRETE_SPAGHETTI)  // 添加食物属性
            .stacksTo(1)
    ) {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable World world, 
                                  List<ITextComponent> tooltip, ITooltipFlag flag) {
            tooltip.add(new TranslationTextComponent("effect.specialfood.concrete_warning"));
            super.appendHoverText(stack, world, tooltip, flag);
        }
    }.setRegistryName("concrete_spaghetti");

    // 仰望星空派
    public static final Item STARGAZY_PIE = new Item(
        new Item.Properties()
            .tab(SpecialFood.SPECIAL_FOOD_TAB)
            .food(Foods.STARGAZY_PIE)  // 添加食物属性
            .stacksTo(1)
    ) {
        @Override
        public void appendHoverText(ItemStack stack, @Nullable World world,
                                  List<ITextComponent> tooltip, ITooltipFlag flag) {
            tooltip.add(new TranslationTextComponent("item.specialfood.stargazy_pie.desc"));
            super.appendHoverText(stack, world, tooltip, flag);
        }
    }.setRegistryName("stargazy_pie");
    public static final Item FERMENTED_HERRING = new Item(
    new Item.Properties()
        .tab(SpecialFood.SPECIAL_FOOD_TAB)
        .food(Foods.FERMENTED_HERRING)
        .stacksTo(16)  // 堆叠上限1
) {
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world,
                              List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("item.specialfood.fermented_herring.desc"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}.setRegistryName("fermented_herring");
public static final Item GRILLED_REBAR = new Item(
    new Item.Properties()
        .tab(SpecialFood.SPECIAL_FOOD_TAB)
        .food(Foods.GRILLED_REBAR)
        .stacksTo(1)
) {
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof LivingEntity && !world.isClientSide) {
            ((LivingEntity)entity).addEffect(new EffectInstance(
                Effects.MOVEMENT_SLOWDOWN, 100, 0)); // 背包中持续获得缓慢I
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world,
                              List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("item.specialfood.grilled_rebar.desc"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}.setRegistryName("grilled_rebar");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(  
            CONCRETE_SPAGHETTI,
            STARGAZY_PIE,
            FERMENTED_HERRING,
            GRILLED_REBAR
        );
    }
}