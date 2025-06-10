package com.yuanshiguang.specialfood;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

@Mod("specialfood")
public class SpecialFood {
    public static final String MOD_ID = "specialfood";
    
    public static final ItemGroup SPECIAL_FOOD_TAB = new ItemGroup("specialfood") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CONCRETE_SPAGHETTI);
        }
    };

    public SpecialFood() {
        // 注册事件总线
        MinecraftForge.EVENT_BUS.register(this);
        
        // 获取Mod事件总线并添加监听器
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // 初始化检查
        if (ModItems.CONCRETE_SPAGHETTI == null || ModItems.STARGAZY_PIE == null) {
            throw new IllegalStateException("物品未正确注册！");
        }
        System.out.println("[" + MOD_ID + "] 模组初始化完成");
    }
}