package dev.Insane1337.AccesstokenLogin;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = ExampleMod.MODID,
        name = ExampleMod.MODNAME,
        version = ExampleMod.VERSION)
public class ExampleMod { // select ExampleMod and hit shift+F6 to rename it

    public static final String MODID = "1337";      // the id of your mod, it should never change, it is used by forge and servers to identify your mods
    public static final String MODNAME = "AccesstokenLogin";// the name of your mod
    public static final String VERSION = "1.0";           // the current version of your mod

    // this method is one entry point of you mod
    // it is called by forge when minecraft is starting
    // it is called before the other methods below
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        if (Loader.isModLoaded("patcher")) {
            // this code will only run if the mod with id "patcher" is loaded
            // you can use it to load or not while modules of your mod that depends on other mods
        }

    }
}