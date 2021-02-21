package re.domi.fastchest.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen
{
    private static final Text SCREEN_TITLE = new LiteralText("FastChest config");
    private static final String SIMPLIFIED_ON = "Simplified chest: ON";
    private static final String SIMPLIFIED_OFF = "Simplified chest: OFF";
    private static final String DONE = "Done";

    private final Screen parent;

    ConfigScreen(Screen parent)
    {
        super(SCREEN_TITLE);
        this.parent = parent;
    }

    @Override
    public void init()
    {
        this.addButton(new ButtonWidget(this.width / 2 - 100, 50, 200, 20,
            Config.simplifiedChest ? SIMPLIFIED_ON : SIMPLIFIED_OFF,
            button ->
            {
                Config.simplifiedChest = !Config.simplifiedChest;
                button.setMessage(Config.simplifiedChest ? SIMPLIFIED_ON : SIMPLIFIED_OFF);
                Config.write();

                if (this.minecraft != null)
                {
                    this.minecraft.worldRenderer.reload();
                }
            }));

        this.addButton(new ButtonWidget(this.width / 2 - 100, this.height - 50, 200, 20, DONE,
            button ->
            {
                if (this.minecraft != null)
                {
                    this.minecraft.openScreen(this.parent);
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
    public void render(int mouseX, int mouseY, float delta)
    {
        this.renderBackground();
        this.drawCenteredString(this.font, this.title.asFormattedString(), this.width / 2, 5, 0xFFFFFF);
        super.render(mouseX, mouseY, delta);
    }
}
