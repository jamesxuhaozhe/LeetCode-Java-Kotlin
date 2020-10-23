package concurrency._1242;

import java.util.*;
import java.util.concurrent.*;

public class Solution {

    private final Queue<String> taskQueue = new ConcurrentLinkedQueue<>();
    private final Set<String> result = new ConcurrentSkipListSet<>();
    private String hostname;

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.crawl("http://news.yahoo.com/news/topics/", new HtmlParserImpl()));
    }

    private static String extractDomainName(String url) {
        String host = url.substring(7); // all urls use http protocol
        int idx = host.indexOf('/');
        if (idx == -1) return host;
        return host.substring(0, idx);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        hostname = extractDomainName(startUrl);

        taskQueue.offer(startUrl);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        while (!taskQueue.isEmpty()) {

            Iterator<String> iterator = taskQueue.iterator();
            int size = taskQueue.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);

            while (iterator.hasNext()) {
                String url = iterator.next();
                iterator.remove();
                executorService.submit(new CrawlTask(url, countDownLatch, htmlParser));
            }

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executorService.shutdown();
        return new ArrayList<>(result);
    }

    private boolean hostnameMatch(String extractDomainName) {
        return hostname.equals(extractDomainName);
    }

    private interface HtmlParser {
        List<String> getUrls(String url);
    }

    private static class HtmlParserImpl implements HtmlParser {

        private static final Map<String, List<String>> URL_MAP = new HashMap<>();

        static {
            URL_MAP.put("http://news.yahoo.com/news/topics/", Arrays.asList("http://news.yahoo.com", "http://news.yahoo.com/news"));
            URL_MAP.put("http://news.google.com", Arrays.asList("http://news.yahoo.com/news", "http://news.yahoo.com/news/topics/"));
            URL_MAP.put("http://news.yahoo.com", Arrays.asList("http://news.yahoo.com/us"));
            URL_MAP.put("http://news.yahoo.com/news", Collections.emptyList());
            URL_MAP.put("http://news.yahoo.com/us", Collections.emptyList());
        }

        @Override
        public List<String> getUrls(String url) {

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return URL_MAP.getOrDefault(url, Collections.emptyList());
        }
    }

    private class CrawlTask implements Runnable {

        private final String startUrl;

        private final CountDownLatch countDownLatch;

        private final HtmlParser htmlParser;

        private CrawlTask(final String startUrl, final CountDownLatch countDownLatch, final HtmlParser htmlParser) {
            this.startUrl = startUrl;
            this.countDownLatch = countDownLatch;
            this.htmlParser = htmlParser;
        }

        @Override
        public void run() {
            try {
                // let's add the startUrl because it is for sure a valid result
                result.add(startUrl);

                List<String> urlsCrawled = htmlParser.getUrls(startUrl);

                for (String urlCrawled : urlsCrawled) {
                    if (!result.contains(urlCrawled) && hostnameMatch(extractDomainName(urlCrawled))) {
                        taskQueue.offer(urlCrawled);
                    }
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
