package sdi.proiect.service;


import sdi.proiect.model.Channel;
import sdi.proiect.model.News;
import sdi.proiect.model.User;

public class NotificationService {

    public void sendNotification(User user, News news, String channelName) {
        if (user.getSubscribedChannels().contains(channelName)) {
            String notification = "New article in " + channelName + ": " + news.getTitle();
            user.addNotification(notification);
        }
    }

    public void broadcastNewsToSubscribers(Channel channel, News news) {
        for (User subscriber : channel.getSubscribers()) {
            sendNotification(subscriber, news, channel.getName());
        }
    }
}
