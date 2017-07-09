package com.baron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jason on 2017/7/9.
 */
public class ZuulTestApplication {
    public static void main(String[] args) throws InterruptedException {
        String[] urls = new String[]{"http://localhost/service-a", "http://localhost/service-b"};
        RestTemplate restTemplate = new RestTemplate();
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger failedCount = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Random random = new Random();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000 * 1000; ++i) {
            final String url = urls[Math.abs(random.nextInt() % 2)];

            executorService.submit(() -> {
                try {
                    String result = restTemplate.getForObject(url, String.class);
                    count.addAndGet(1);
                } catch (Throwable e) {
                    failedCount.addAndGet(1);
                }
            });
        } // for

        while (count.get() + failedCount.get() < 10000 * 1000) {
            System.out.println("qps: " + count.get() / (System.currentTimeMillis() - start) / 1000);
            Thread.currentThread().sleep(1000);
        }

        System.out.println("used time: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("success percent: " + (failedCount.get() / 1000.0 / 10000.0) + "%");
    }
}
