# FastChest

If your storage room contains a lot of chests, you have probably noticed how bad Minecraft is at rendering them. The more chests are placed, the lower your FPS go.

FastChest helps by removing their dynamic models (aka BlockEntityRenderer) and making them render as static chunk geometry, like most normal blocks. (This means they will lose their lid opening animation! Check out [Enhanced Block Entities](https://modrinth.com/mod/ebe) if you care about that.)

Depending on how many chests you have around, you'll see varying effectiveness. In large storage rooms this mod can easily double your FPS, but keep in mind that chests aren't the only thing responsible for bad performance.

FastChest works with Sodium and Optifine and should be compatible with all other mods and resource packs that leave chests alone. One example that does not is the *Vanilla Tweaks Proper Break Particles* resource pack. It overwrites the chest blockstate definitions and is not compatible out of the box. You can however delete `chest.json`, `ender_chest.json` and `trapped_chest.json` from the `/assets/minecraft/blockstates` directory of your resource pack to make it work with the mod.

A classic (full-block) chest resource pack can be downloaded from [here](https://up.domi.re/pa1f7rxa).