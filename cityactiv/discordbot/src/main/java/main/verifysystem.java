package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;

public class verifysystem extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("b.setup verify")) {

            if (ereignis.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {

                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("Verifiziere dich hier!");
                embed.setThumbnail("https://cdn.discordapp.com/attachments/975325778059337730/989227045722685490/Download-removebg-preview.png");
                embed.setColor(0x42b580);
                embed.setDescription("Verhalte dich immer höflich und respektvoll gegenüber den anderen Nutzern!");
                embed.addField(":question: Wie kann ich mich Verifizieren?", "Klicke auf den Button unter dieser Nachricht!", true);

                Button button = Button.success("verify", "Verifiziere dich hier!").withEmoji(Emoji.fromMarkdown("✅"));

                ereignis.getChannel().sendMessageEmbeds(embed.build()).setActionRow(button).queue();

            }

        }

    }

    public void onButtonInteraction (ButtonInteractionEvent ereignis) {

        if (ereignis.getButton().getId().equals("verify")) {

            Role verifyrole = ereignis.getGuild().getRoleById("954812564246769664");

            ereignis.getGuild().addRoleToMember(ereignis.getMember(), verifyrole).queue();

            ereignis.reply("Du hast dich erfolgreich verifiziert!").setEphemeral(true).queue();

        }

    }

}
