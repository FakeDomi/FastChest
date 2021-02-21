package re.domi.fastchest.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class ModMenuImpl implements ModMenuApi
{
    private static final String MOD_ID = "fastchest";

    @Override
    public String getModId()
    {
        return MOD_ID;
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return ConfigScreen::new;
    }
}
