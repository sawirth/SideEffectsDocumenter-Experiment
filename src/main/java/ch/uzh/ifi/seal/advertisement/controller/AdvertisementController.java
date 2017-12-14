package ch.uzh.ifi.seal.advertisement.controller;

import ch.uzh.ifi.seal.advertisement.model.AdvertisementPage;
import ch.uzh.ifi.seal.advertisement.model.Video;
import ch.uzh.ifi.seal.advertisement.service.AdvertisementPageService;
import ch.uzh.ifi.seal.advertisement.service.VideoEditor;
import ch.uzh.ifi.seal.advertisement.service.YoutubeService;
import ch.uzh.ifi.seal.customer.model.Customer;
import ch.uzh.ifi.seal.customer.service.CustomerService;
import ch.uzh.ifi.seal.advertisement.service.SpamService;
import ch.uzh.ifi.seal.pricing.service.DealOfferService;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.HashSet;
import java.util.Set;

public class AdvertisementController {
    private final AdvertisementPageService advertisementPageService;
    private final CustomerService customerService;
    private final SpamService spamService;
    private final YoutubeService youtubeService;
    private final VideoEditor videoEditor;
    private final DealOfferService dealOfferService;

    public AdvertisementController() {
        advertisementPageService = new AdvertisementPageService();
        customerService = new CustomerService();
        spamService = new SpamService();
        youtubeService = new YoutubeService();
        videoEditor = new VideoEditor();
        dealOfferService = new DealOfferService();
    }

    public void createTheUltimateAdvertisement(Product product) {
        //First we want to design a nice advertisement page in our shop and make it available online
        AdvertisementPage advertisementPage = advertisementPageService.createNewAdvertisementPage(product);
        advertisementPage.makeVisibleInShop();

        //Next step is to send some spam mails to our customers
        Set<Customer> customers = customerService.loadCustomers();
        Set<String> emailAddresses = new HashSet<>();
        for (Customer customer : customers) {
            emailAddresses.add(customer.Email);
        }

        spamService.sendSpam(product, emailAddresses);
        
        //Annoying Youtube Spots are also a great idea so let us create some, customers gonna love 'em
        Video video = videoEditor.createAdvertisementVideo(product, 120);
        youtubeService.uploadYoutubeVideo(video);

        //Customers always want to make a good deal so we offer them one but we limit the quantity
        double discount = 0.5;
        int quantity = 100;
        dealOfferService.makeDeal(discount, quantity, product);
    }
}
