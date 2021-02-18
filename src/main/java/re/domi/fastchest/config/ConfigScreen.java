package re.domi.fastchest.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;

public class ConfigScreen extends Screen {
    private ButtonWidget SIMPLIFIED_CHEST_OPTION;

    private final Screen parent;

    ConfigScreen(Screen parent) {
        super(new LiteralText("Fast Chest Config"));
        this.parent = parent;
    }

    private void updateState() {
        this.SIMPLIFIED_CHEST_OPTION.setMessage("Apply simplified chest: " + Configs.simplifiedChestRendering);
        if (this.minecraft != null) {
            if (this.minecraft.player != null) {
                this.minecraft.player.addChatMessage(new LiteralText("§e§l[FastChest]: §f§rYou may have to refresh rendering chunks (F3+A) to update chest rendering."), false);
            }
        }
    }

    @Override
    public void init() {
        this.SIMPLIFIED_CHEST_OPTION = new ButtonWidget(
                (int) (this.width * 0.2), (int) (this.height * 0.2), 204, 20,
                "Apply simplified chest: " + Configs.simplifiedChestRendering,
                (buttonWidget) -> {
                    Configs.simplifiedChestRendering = !Configs.simplifiedChestRendering;
                    this.updateState();
                    Configs.write();
                });
        this.addButton(SIMPLIFIED_CHEST_OPTION);
    }

    @Override
    public void onClose() {
        if (this.minecraft != null) {
            this.minecraft.openScreen(this.parent);
        }
    }

    @Override
    public void removed() {

    }

    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.drawCenteredString(this.font, this.title.asFormattedString(), this.width / 2, 5, 16777215);
        super.render(mouseX, mouseY, delta);
    }

}
