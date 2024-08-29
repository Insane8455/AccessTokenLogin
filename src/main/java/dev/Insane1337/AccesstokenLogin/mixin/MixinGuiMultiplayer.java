package dev.Insane1337.AccesstokenLogin.mixin;

import dev.Insane1337.AccesstokenLogin.gui.CustomLoginScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMultiplayer.class)
public class MixinGuiMultiplayer extends GuiScreen {

    @Inject(method = "initGui", at = @At("RETURN"))
    public void hookButton(CallbackInfo ci) {
            buttonList.add(new GuiButton(1_000_000_000, 5, 5, 100, 20, "Login"));
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    public void handleButtonClicking(GuiButton p_actionPerformed_1_, CallbackInfo ci) {
            if (p_actionPerformed_1_.id == 1_000_000_000) {
                mc.displayGuiScreen(new CustomLoginScreen());
            }
    }
    
}