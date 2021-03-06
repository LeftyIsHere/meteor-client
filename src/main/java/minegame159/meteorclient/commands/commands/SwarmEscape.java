package minegame159.meteorclient.commands.commands;

import baritone.api.BaritoneAPI;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import minegame159.meteorclient.commands.Command;
import minegame159.meteorclient.modules.ModuleManager;
import minegame159.meteorclient.modules.combat.Swarm;
import minegame159.meteorclient.utils.Chat;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class SwarmEscape extends Command {

    public SwarmEscape() {
        super("s", "(highlight)escape(default)- Removes this player from the active swarm.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("escape").executes(context -> {
                    Swarm swarm = ModuleManager.INSTANCE.get(Swarm.class);
                    if (swarm.isActive()) {
                        if (swarm.currentMode.get() != Swarm.Mode.QUEEN) {
                            swarm.closeAllServerConnections();
                            if (BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing())
                                BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
                            swarm.currentMode.set(Swarm.Mode.IDLE);
                            swarm.currentTaskSetting.set(Swarm.CurrentTask.IDLE);
                            ModuleManager.INSTANCE.get(Swarm.class).toggle();
                        } else {
                            Chat.info("Swarm: You are the queen.");
                        }
                    }
                    return SINGLE_SUCCESS;
                })
        );
    }
}
