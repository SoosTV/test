package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class regeln extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

            if (ereignis.getMessage().getContentStripped().equals("b.rules")) {

                EmbedBuilder embed = new EmbedBuilder();

                embed.setTitle("Regeln");
                embed.setDescription("Lesst sie euch gut durch!");
                embed.setColor(0x0768fa);
                embed.addField("**§1.1 Namensgebung**", "Nicknames dürfen keine beledigenden oder andere verbotenen oder geschützten Namen oder Namensteile enthalten.", false);
                embed.addField("**§1.2 Avatar**", "Avatare dürfen keine pornographischen, rassistischen oder beleidigenden Inhalte beinhalten.", false);
                embed.addField("**§2 Umgangston**", "Der Umgang mit anderen Discord Benutzern sollte stets freundlich sein. Verbale Angriffe gegen andere User sind strengstens untersagt.", false);
                embed.addField("**§2.2 Gespräche aufnehmen**", "Das Mitschneiden von Gesprächen ist auf dem gesamten Server nur nach Absprache mit den anwesenden Benutzern des entsprechenden Channels erlaubt. Willigt ein User nicht der Aufnahme ein, ist die Aufnahme des Gesprächs verboten.", false);
                embed.addField("**§2.3 Abwesenheit**", "Bei längerer Abwesenheit wird der Benutzer gebeten in den entsprechnden AFK-Channel zu gehen.", false);
                embed.addField("**§3 Kicken/Bannen**", "Ein Kick oder Bann ist zu keinem Zeitpunkt unbegründet, sondern soll zum Nachdenken der eigenen Verhaltensweise anregen. Unangebrachte Kicks/Banns müssen den zuständigen Admins gemeldet werden.", false);
                embed.addField("**§3.2 Discord Rechte**", "Discord Rechte werden nicht wahllos vergeben, sondern dienen immer einem bestimmten Grund. Bei Bedarf von Rechten kann sich an den zuständigen Admin gewandt werden.", false);
                embed.addField("**§3.3 Weisungsrecht**", "Server Admins, Moderatoren oder anderweitig befugte Admins haben volles Weisungsrecht. Das Verweigern einer bestimmten Anweisung kann zu einem Kick oder Bann führen.", false);
                embed.addField("**§4.1 Werbung**", "Jegliche Art von Werbung ist auf diesem Server untersagt. Ggf. kann sich an einen zuständigen Admin gewandt werden, um über eine Möglichkeit zur Werbung zu verhandeln.", false);
                embed.addField("**§4.2 Datenschutz**", "Private Daten wie Telefonnummern, Adressen, Passwörter und ähnlichem dürfen nicht öffentlich ausgetauscht werden.", false);
                embed.addField("**§5.1 Eigene Musik/Töne**", "Das Einspielen von eigener Musik, oder das Übetragen von anderen nicht erwünschten Tönen ist untersagt", false);

                ereignis.getChannel().sendMessageEmbeds(embed.build()).queue();

            }

        }
    }