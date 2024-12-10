package sdi.proiect.service;



import sdi.proiect.model.Channel;
import sdi.proiect.model.News;
import sdi.proiect.model.User;

import java.util.HashMap;
import java.util.Map;

public class ChannelService {
    private Map<String, Channel> channels;

    public ChannelService() {
        this.channels = new HashMap<>();
    }

    public void createChannel(String channelName) {
        if (!channels.containsKey(channelName)) {
            channels.put(channelName, new Channel(channelName));
        }
    }

    public void addNewsToChannel(String channelName, News news) {
        Channel channel = channels.get(channelName);
        if (channel != null) {
            channel.addNews(news);
        }
    }

    public void subscribeUserToChannel(String channelName, User user) {
        Channel channel = channels.get(channelName);
        if (channel != null) {
            channel.subscribeUser(user);
            user.subscribeToChannel(channelName);
        }
    }

    public Map<String, Channel> getChannels() {
        return channels;
    }

    // Noua metodă pentru listarea știrilor
    public void listNewsFromChannel(String channelName) {
        Channel channel = channels.get(channelName);
        if (channel != null) {
            System.out.println("News in channel: " + channelName);
            if (channel.getNewsList().isEmpty()) {
                System.out.println("No news available in this channel.");
            } else {
                for (News news : channel.getNewsList()) {
                    System.out.println("- " + news);
                }
            }
        } else {
            System.out.println("Channel not found: " + channelName);
        }
    }
}
