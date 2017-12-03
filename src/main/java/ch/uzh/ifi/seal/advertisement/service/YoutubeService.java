package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.helper.YoutubeApi;
import ch.uzh.ifi.seal.advertisement.model.Video;
import ch.uzh.ifi.seal.log.Logger;

public class YoutubeService {
    private final Logger logger;

    public YoutubeService() {
        logger = new Logger();
    }

    public void uploadYoutubeVideo(Video video) {
        boolean success = YoutubeApi.upload(video);
        if (success) {
            logger.log("Video successfully uploaded");
        } else {
            logger.log("Error while uploading the video. Please try again.");
        }
    }
}
