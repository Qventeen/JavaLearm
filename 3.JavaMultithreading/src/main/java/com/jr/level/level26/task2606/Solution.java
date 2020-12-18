package com.jr.level.level26.task2606;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
Тот, кто любит труд, не нуждается в развлечениях
*/
public class Solution {
    private final URL jrUrl;
    private final URL jrUrl1Child;
    private final URL jrVkGroupUrl;
    private final URL jrVkGroupUrl1Child;
    private final URL jrVkGroupUrl2Child;
    private final URL jrVkGroupUrl3Child;

    private volatile ExecutorService executorService;
    private final Set<URL> urlsForProcessing = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Solution solution = new Solution();
        solution.start();
        Thread.sleep(1000);
        solution.stop();
    }

    public Solution() throws MalformedURLException {
        jrUrl = new URL("http://google.com/");
        jrVkGroupUrl = new URL("http://vk.com/");
        jrUrl1Child = new URL("http://info.google.com/page/FAQ/");
        jrVkGroupUrl1Child = new URL("https://plus.google.com/114772402300089087607/about");
        jrVkGroupUrl2Child = new URL("https://www.facebook.com/pages/JR/524321077686033");
        jrVkGroupUrl3Child = new URL("https://twitter.com/jr_ru");

        urlsForProcessing.add(jrUrl);
        urlsForProcessing.add(jrVkGroupUrl);
    }

    public synchronized void start() {
        executorService = Executors.newCachedThreadPool();
        for (URL url : urlsForProcessing) {
            submitUrlTask(url);
        }
        urlsForProcessing.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUnprocessedUrls(executorService.shutdownNow());
            if (executorService.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                saveUnprocessedUrls(getCancelledTasksFromExecutor());
            }
        } finally {
            executorService = null;
        }
    }

    private List<Runnable> getCancelledTasksFromExecutor() {
        return Collections.EMPTY_LIST;
    }

    protected List<URL> processPage(URL url) {
        System.out.println(url + " will be processed");
        return getChildUrlByParent(url);
    }

    private List<URL> getChildUrlByParent(URL url) {
        List<URL> result = new ArrayList<>();

        if (jrUrl.equals(url)) {
            result.add(jrUrl1Child);
        } else if (jrVkGroupUrl.equals(url)) {
            result.add(jrVkGroupUrl1Child);
            result.add(jrVkGroupUrl2Child);
            result.add(jrVkGroupUrl3Child);
        }
        return result;
    }

    private void saveUnprocessedUrls(List<Runnable> unprocessed) {
        for (Runnable task : unprocessed) {
            urlsForProcessing.add(((UrlTask) task).getPage());
        }
    }

    private void submitUrlTask(URL url) {
        executorService.execute(new UrlTask(url));
    }

    public class UrlTask implements Runnable {
        private final URL url;

        private UrlTask(URL url) {
            this.url = url;
        }

        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) return;
                submitUrlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}
