package sdi.proiect.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<String> subscribedChannels;
    private List<String> notifications;

    public User(String name) {
        this.name = name;
        this.subscribedChannels = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSubscribedChannels() {
        return subscribedChannels;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void subscribeToChannel(String channelName) {
        if (!subscribedChannels.contains(channelName)) {
            subscribedChannels.add(channelName);
        }
    }

    public void addNotification(String notification) {
        notifications.add(notification);
    }
}
