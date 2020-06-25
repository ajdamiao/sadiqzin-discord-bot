import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;


public class PingPong extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getMessage().getContentRaw().equals("+ping"))
        {
            e.getChannel().sendMessage(createEmbed()).queue();
        }
    }

    public MessageEmbed createEmbed()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Ping Pong");
        embedBuilder.setThumbnail("https://pbs.twimg.com/media/DUqNNU_XcAETn8R.jpg");
        embedBuilder.addField("Olha o japa das bolinhas","Pong!" + "    \uD83C\uDFD3",true);
        embedBuilder.setFooter("San é incrivel");
        embedBuilder.addBlankField(true);
        return embedBuilder.build();
    }
}
