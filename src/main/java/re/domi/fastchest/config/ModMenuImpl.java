package re.domi.fastchest.config;


import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class ModMenuImpl implements ModMenuApi
{
    @Override
    public String getModId()
    {
        return "fastchest";
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return ConfigScreen::new;
    }
}
