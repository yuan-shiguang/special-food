package com.yuanshiguang.specialfood;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Foods {
    public static final Food CONCRETE_SPAGHETTI = (new Food.Builder())
        .nutrition(10)              // 饥饿值恢复量
        .saturationMod(0.6F)       // 饱和度
        .effect(() -> new EffectInstance(Effects.CONFUSION, 30 * 20, 1), 1.0F)  // 100%反胃II 30秒
        .effect(() -> new EffectInstance(Effects.WITHER, 10 * 20, 0), 0.4F)       // 40%凋零I 10秒
        .alwaysEat()               // 随时可以吃
        .build();
    public static final Food STARGAZY_PIE = (new Food.Builder())
        .nutrition(8)
        .saturationMod(0.8F)
        .effect(() -> new EffectInstance(Effects.WATER_BREATHING, 300 * 20, 0), 1.0F) //水下呼吸5分钟
        .effect(() -> new EffectInstance(Effects.CONFUSION, 5 * 20, 0), 0.1F) //10%反胃I
        .alwaysEat()
        .build();
    public static final Food FERMENTED_HERRING = (new Food.Builder())
        .nutrition(10)              // 恢复10点饥饿值(5鸡腿)
        .saturationMod(0.3F)        // 低饱和度
        .effect(() -> new EffectInstance(Effects.CONFUSION, 30 * 20, 2), 1.0F) // 100%反胃III 30秒
        .alwaysEat()                // 饥饿时也能吃
        .build();    
    public static final Food GRILLED_REBAR = (new Food.Builder())
        .nutrition(1)               // 几乎不恢复饥饿
        .saturationMod(0.1F)        // 极低饱和度
        .effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*20, 0), 1.0F) // 100%缓慢I 20秒
        .alwaysEat()                // 随时可吃
        .build();
}