package ch.uzh.ifi.seal.advertisement.helper;

import ch.uzh.ifi.seal.advertisement.model.Video;

public class YoutubeApi {
    public static boolean upload(Video video) {
        return true;
    }

    public static Video downloadVideo(String url) {
        return new Video(url, 180);
    }
}
