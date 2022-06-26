package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class viewcommand extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("b.view")) {

            Member mitglied = ereignis.getMessage().getMentions().getMembers().get(0);

            EmbedBuilder embed = new EmbedBuilder();

            embed.setTitle("Nutzerinformation zu " + mitglied.getEffectiveName());
            embed.addField("Nutzer-ID", mitglied.getId(), true);
            embed.setColor(0x0768fa);
            embed.setThumbnail(mitglied.getEffectiveAvatarUrl());

            Button kickButton = Button.secondary("kick" + mitglied.getId(), "Mitglied Kicken");
            Button banButton = Button.danger("ban" + mitglied.getId(), "Mitglied Bannen");
            Button profilebutton = Button.link(mitglied.getEffectiveAvatarUrl(), "Profilbild abrufen");

            if (mitglied.getNickname() != null) {
                embed.addField("Nickname", mitglied.getNickname(), true);
            }

            ereignis.getChannel().sendMessageEmbeds(embed.build()).setActionRow(kickButton, banButton, profilebutton).queue();

        }

    }

    public void onButtonInteraction(ButtonInteractionEvent ereignis) {

        if (ereignis.getButton().getId().startsWith("kick")) {

            if (ereignis.getMember().getPermissions().contains(Permission.KICK_MEMBERS)) {

                String nutzerID = ereignis.getButton().getId().substring(4);

                ereignis.getGuild().kick(UserSnowflake.fromId(nutzerID)).queue();

                ereignis.reply("Bestrafung erfolgreich!").queue();

            } else {

                ereignis.reply("Dir fehlen die Rechte hierzu!").setEphemeral(true).queue();
            }

        } else if (ereignis.getButton().getId().startsWith("ban")) {

        } if (ereignis.getButton().getId().startsWith("ban")) {

            if (ereignis.getMember().getPermissions().contains(Permission.BAN_MEMBERS)) {

                String nutzerID = ereignis.getButton().getId().substring(3);

                ereignis.getGuild().ban(UserSnowflake.fromId(nutzerID), 7, "Ban eines Teammitglied").queue();
                ereignis.reply("Der Nutzer wurde gebannt!").setEphemeral(true).queue();

            } else {
                ereignis.reply("Für diesen Button hast du keine Rechte!").queue();
            }

        }

    }

}
