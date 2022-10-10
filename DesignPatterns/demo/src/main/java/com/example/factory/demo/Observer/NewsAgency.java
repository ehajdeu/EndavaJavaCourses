package com.example.factory.demo.Observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    public void subscribe(Channel channel) {
        this.channels.add(channel);
    }

    public void unsubscribe(Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
