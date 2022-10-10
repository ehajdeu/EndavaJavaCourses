package com.example.factory.demo;

import com.example.factory.demo.Observer.NewsAgency;
import com.example.factory.demo.Observer.NewsChannel;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void testObserver() {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer1 = new NewsChannel();
        NewsChannel observer2 = new NewsChannel();

        observable.subscribe(observer1);
        observable.subscribe(observer2);
        System.out.println(">>>>>>>>>>The number of observers is: " + observable.getChannels().size());

        observable.setNews("news1");

        System.out.println("The news for Observer1 are " + observer1.getNews());
        System.out.println("The news for Observer2 are " + observer2.getNews());

        System.out.println("");

        observable.unsubscribe(observer2);
        System.out.println(">>>>>>>>>>The number of observers is: " + observable.getChannels().size());

        observable.setNews("news2");

        System.out.println("The news for Observer1 are " + observer1.getNews());
        System.out.println("The news for Observer2 are " + observer2.getNews());
    }
}
