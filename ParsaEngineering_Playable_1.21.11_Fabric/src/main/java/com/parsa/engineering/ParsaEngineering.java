package com.parsa.engineering;

import net.fabricmc.api.ModInitializer;

public class ParsaEngineering implements ModInitializer {
    public static final String MOD_ID = "parsa_engineering";

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        System.out.println("[Parsa Engineering] Industrial machines registered.");
    }
}
