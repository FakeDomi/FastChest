package re.domi.fastchest.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;

public class ConfigScreen extends Screen
{
    private static final String BUTTON_TEXT = "Simplified chest: ";

    private final Screen parent;

    ConfigScreen(Screen parent)
    {
        super(new LiteralText("FastChest config"));
        this.parent = parent;
    }

    @Override
    public void init()
    {
        this.addButton(new ButtonWidget((int)(this.width * 0.2), (int)(this.height * 0.2), 204, 20,
            BUTTON_TEXT + Config.simplifiedChestRendering,
            (buttonWidget) ->
            {
                Config.simplifiedChestRendering = !Config.simplifiedChestRendering;
                buttonWidget.setMessage(BUTTON_TEXT + Config.simplifiedChestRendering);
                Config.write();

                if (this.minecraft != null)
                {
                    this.minecraft.worldRenderer.reload();
                }
            }));
    }

    @Override
    public void onClose()
    {
        if (this.minecraft != null)
        {
            this.minecraft.openScreen(this.parent);
        }
    }

    @Override
    public void removed()
    {
    }

    public void render(int mouseX, int mouseY, float delta)
    {
        this.renderBackground();
        this.drawCenteredString(this.font, this.title.asFormattedString(), this.width / 2, 5, 0xFFFFFF);
        super.render(mouseX, mouseY, delta);
    }
}
