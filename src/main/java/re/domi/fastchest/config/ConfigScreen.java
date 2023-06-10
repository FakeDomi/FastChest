package re.domi.fastchest.config;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen
{
    private static final Text SCREEN_TITLE = Text.literal("FastChest config");
    private static final Text SIMPLIFIED_ON = Text.literal("Simplified chest: ON");
    private static final Text SIMPLIFIED_OFF = Text.literal("Simplified chest: OFF");

    private final Screen parent;

    ConfigScreen(Screen parent)
    {
        super(SCREEN_TITLE);
        this.parent = parent;
    }

    @Override
    public void init()
    {
        this.addDrawableChild(new ButtonWidget.Builder(
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
            })
            .dimensions(this.width / 2 - 100, 50, 200, 20)
            .build());

        this.addDrawableChild(new ButtonWidget.Builder(
            ScreenTexts.DONE,
            button ->
            {
                if (this.client != null)
                {
                    this.client.setScreen(this.parent);
                }
            })
            .dimensions(this.width / 2 - 100, this.height - 50, 200, 20)
            .build());
    }

    @Override
    public void close()
    {
        if (this.client != null)
        {
            this.client.setScreen(this.parent);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta)
    {
        this.renderBackground(context);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 5, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}
