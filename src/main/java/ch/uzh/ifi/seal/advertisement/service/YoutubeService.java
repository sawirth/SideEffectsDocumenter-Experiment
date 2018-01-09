package ch.uzh.ifi.seal.advertisement.service;

import ch.uzh.ifi.seal.advertisement.helper.YoutubeApi;
import ch.uzh.ifi.seal.advertisement.model.Video;
import ch.uzh.ifi.seal.log.Logger;
import ch.uzh.ifi.seal.product.model.Product;

public class YoutubeService {

    private final Logger logger;

    /**
     * Purity: FieldModifier   <br>
     */
    public YoutubeService() {
        logger = new Logger();
    }

    /**
     * Purity: Stateless   <br>
     */
    public void uploadYoutubeVideo(Video video) {
        boolean success = YoutubeApi.upload(video);
        if (success) {
        //logger.log("Video successfully uploaded");
        } else {
        //logger.log("Error while uploading the video. Please try again.");
        }
    }

    /**
     * Purity: Stateless   <br>
     */
    public Video downloadVideo(Product product) {
        return YoutubeApi.downloadVideo("https://www.youtube.com");
    }
}
