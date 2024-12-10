package sdi.proiect.model;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private List<News> newsList;
    private List<User> subscribers;

    public Channel(String name) {
        this.name = name;
        this.newsList = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void addNews(News news) {
        newsList.add(news);
    }

    public void subscribeUser(User user) {
        if (!subscribers.contains(user)) {
            subscribers.add(user);
        }
    }
}
