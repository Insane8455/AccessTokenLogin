package dev.Insane1337.AccesstokenLogin.mixin;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

public class MixinLoader implements IFMLLoadingPlugin {

    public MixinLoader () {
        System.out.println("mixins initialized");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.ILoveU.json");
    }

    @Override
    public String[] getASMTransformerClass () {
        return new String[0];
    }

    @Override
    public String getModContainerClass () {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass () {
        return null;
    }

    @Override
    public void injectData (Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass () {
        return null;
    }
}