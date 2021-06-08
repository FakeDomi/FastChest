package re.domi.fastchest.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen
{
    private static final Text SCREEN_TITLE = new LiteralText("FastChest config");
    private static final Text SIMPLIFIED_ON = new LiteralText("Simplified chest: ON");
    private static final Text SIMPLIFIED_OFF = new LiteralText("Simplified chest: OFF");

    private final Screen parent;

    ConfigScreen(Screen parent)
    {
        super(SCREEN_TITLE);
        this.parent = parent;
    }

    @Override
    public void init()
    {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, 50, 200, 20,
            Config.simplifiedChest ? SIMPLIFIED_ON : SIMPLIFIED_OFF,
            button ->
            {
                Config.simplifiedChest = !Config.simplifiedChest;
                button.setMessage(Config.simplifiedChest ? SIMPLIFIED_ON : SIMPLIFIED_OFF);
                Config.write();

                if (this.client != null)
                {
                    this.client.worldRenderer.reload();
                }
            }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 50, 200, 20, ScreenTexts.DONE,
            button ->
            {
                if (this.client != null)
                {
                    this.client.openScreen(this.parent);
                }
            }));
    }

    @Override
    public void onClose()
    {
        if (this.client != null)
        {
            this.client.openScreen(this.parent);
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title.asString(), this.width / 2, 5, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
