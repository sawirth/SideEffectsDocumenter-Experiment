package ch.uzh.ifi.seal.advertisement.controller;

import ch.uzh.ifi.seal.advertisement.model.AdvertisementPage;
import ch.uzh.ifi.seal.advertisement.model.Video;
import ch.uzh.ifi.seal.advertisement.service.AdvertisementPageService;
import ch.uzh.ifi.seal.advertisement.service.VideoEditor;
import ch.uzh.ifi.seal.advertisement.service.YoutubeService;
import ch.uzh.ifi.seal.customer.model.Customer;
import ch.uzh.ifi.seal.customer.service.CustomerService;
import ch.uzh.ifi.seal.advertisement.service.SpamService;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.Set;
import java.util.stream.Collectors;

public class AdvertisementController {
    private final AdvertisementPageService advertisementPageService;
    private final CustomerService customerService;
    private final SpamService spamService;
    private final YoutubeService youtubeService;
    private final VideoEditor videoEditor;

    public AdvertisementController() {
        this.advertisementPageService = new AdvertisementPageService();
        this.customerService = new CustomerService();
        this.spamService = new SpamService();
        this.youtubeService = new YoutubeService();
        this.videoEditor = new VideoEditor();
    }

    public void createTheUltimateAdvertisement(Product product) {
        //First we want to design a nice advertisement page in our shop and make it available online
        AdvertisementPage advertisementPage = advertisementPageService.createNewAdvertisementPage(product);
        advertisementPage.makeVisibleInShop();

        //Next step is to send some spam mails to our customers
        Set<Customer> customers = customerService.loadCustomers();
        Set<String> emailAddresses = customers.stream()
                .map(c -> c.Email)
                .collect(Collectors.toSet());

        spamService.sendSpam(product, emailAddresses);
        
        //Annoying Youtube Spots are also a great idea so let us create some, customers gonna love 'em
        Video video = videoEditor.createAdvertisementVideo(product, 120);
        youtubeService.uploadYoutubeVideo(video);

        //Customers always want to make a good deal so we offer them one but we limit the quantity
        double discount = 0.5;
        int quantity = 100;
        //TODO Deal mit Seiteneffekt
    }
}
