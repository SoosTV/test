package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NachrichtenReaktion extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent ereignis) {

        if (ereignis.isFromGuild()) {

            if (ereignis.getMessage().getContentStripped().equals("hallo")) {

                String username = ereignis.getAuthor().getName();

                ereignis.getChannel().sendMessage("Hallo " + username + "!").queue();

                //reaktion

                ereignis.getMessage().addReaction("✅").queue();

            } else if (ereignis.getMessage().getContentStripped().equals("b.help")) {

                EmbedBuilder embed = new EmbedBuilder();

                embed.setTitle("Help Menu");
                embed.setDescription("$view, $help");
                embed.setColor(0x0768fa);

                ereignis.getChannel().sendMessageEmbeds(embed.build()).queue();

            }

        }

    }

}
