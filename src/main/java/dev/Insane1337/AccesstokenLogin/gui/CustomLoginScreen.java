package dev.Insane1337.AccesstokenLogin.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.Session;
import org.lwjgl.input.Keyboard;

import java.io.IOException;
import java.lang.reflect.Field;

public class CustomLoginScreen extends GuiScreen {
    private GuiTextField usernameField;
    private GuiTextField uuidField;
    private GuiTextField accessTokenField;
    private GuiButton doneButton;

    @Override
    public void initGui() {

        int textBoxWidth = 200;
        int textBoxHeight = 20;
        int buttonWidth = 100;
        int buttonHeight = 20;
        int gap = 10;


        this.usernameField = new GuiTextField(0, this.fontRendererObj, this.width / 2 - textBoxWidth / 2, this.height / 2 - textBoxHeight * 2 - gap, textBoxWidth, textBoxHeight);
        this.usernameField.setFocused(true);


        this.uuidField = new GuiTextField(1, this.fontRendererObj, this.width / 2 - textBoxWidth / 2, this.height / 2 - textBoxHeight - gap / 2, textBoxWidth, textBoxHeight);


        this.accessTokenField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - textBoxWidth / 2, this.height / 2 + gap / 2, textBoxWidth, textBoxHeight);
        accessTokenField.setMaxStringLength(5000);

        this.doneButton = new GuiButton(3, this.width / 2 - buttonWidth / 2, this.height / 2 + textBoxHeight + gap * 2, buttonWidth, buttonHeight, "Done");
        this.buttonList.add(this.doneButton);

        Keyboard.enableRepeatEvents(true);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 3) {
            String username = this.usernameField.getText();
            String uuid = this.uuidField.getText();
            String accessToken = this.accessTokenField.getText();
            Session session = new Session(username, uuid, accessToken, "mojang");

            try {
                Field sessionField = Minecraft.class.getDeclaredField("session"); //srgname field_71449_j
                sessionField.setAccessible(true);
                sessionField.set(Minecraft.getMinecraft(), session);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);

        this.usernameField.textboxKeyTyped(typedChar, keyCode);
        this.uuidField.textboxKeyTyped(typedChar, keyCode);
        this.accessTokenField.textboxKeyTyped(typedChar, keyCode);

        if (keyCode == Keyboard.KEY_TAB) {
            if (this.usernameField.isFocused()) {
                this.usernameField.setFocused(false);
                this.uuidField.setFocused(true);
            } else if (this.uuidField.isFocused()) {
                this.uuidField.setFocused(false);
                this.accessTokenField.setFocused(true);
            } else if (this.accessTokenField.isFocused()) {
                this.accessTokenField.setFocused(false);
                this.usernameField.setFocused(true);
            }
        } else if (keyCode == Keyboard.KEY_RETURN || keyCode == Keyboard.KEY_NUMPADENTER) {
            actionPerformed(this.doneButton);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);

        this.usernameField.mouseClicked(mouseX, mouseY, mouseButton);
        this.uuidField.mouseClicked(mouseX, mouseY, mouseButton);
        this.accessTokenField.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

            this.usernameField.drawTextBox();
            this.uuidField.drawTextBox();
            this.accessTokenField.drawTextBox();

        this.drawCenteredString(this.fontRendererObj, "bilibili/douyin Insane1337", this.width / 2, this.height / 2 - 100, 0xFFFFFF);
        if(!usernameField.isFocused()) {
            this.drawString(this.fontRendererObj, "Username", this.width / 2 - 90, this.height / 2 - 45, 0xA0A0A0);
        }
        if(!uuidField.isFocused()) {
            this.drawString(this.fontRendererObj, "UUID", this.width / 2 - 90, this.height / 2 - 20, 0xA0A0A0);
        }
        if(!accessTokenField.isFocused()) {
            this.drawString(this.fontRendererObj, "AccessToken", this.width / 2 - 90, this.height / 2 + 10, 0xA0A0A0);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
