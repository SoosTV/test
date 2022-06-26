package main;

import commands.regeln;
import commands.viewcommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Hauptklasse {

    public static void main(String[] args) throws LoginException {

        String prefix = "b.";

        System.out.println(prefix);

        String status;
        status = "Cityactiv Verify";

        int zahl = 12;
        double kommazahl = 1.45;


        String token = "OTg4NDM4NjU0NDI5MDU3MDI0.GvHIGE.gz0Smkh2B7biqDm-pjUFnc4K_cVrgaHbaeVqwA";

        JDABuilder bauplan = JDABuilder.createDefault(token);

        bauplan.setStatus(OnlineStatus.ONLINE);
        bauplan.setActivity(Activity.playing(status));

        bauplan.setChunkingFilter(ChunkingFilter.ALL);
        bauplan.setMemberCachePolicy(MemberCachePolicy.ALL);
        bauplan.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES);

        bauplan.addEventListeners(new NachrichtenReaktion());
        bauplan.addEventListeners(new viewcommand());
        bauplan.addEventListeners(new verifysystem());
        bauplan.addEventListeners(new regeln());

        JDA bot = bauplan.build();
        System.out.println("Der bot ist nun gestartet");

    }

}
