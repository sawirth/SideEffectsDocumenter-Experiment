package ch.uzh.ifi.seal.advertisement.controller;

import ch.uzh.ifi.seal.advertisement.model.AdvertisementPage;
import ch.uzh.ifi.seal.advertisement.service.AdvertisementPageService;
import ch.uzh.ifi.seal.customer.model.Customer;
import ch.uzh.ifi.seal.customer.service.CustomerService;
import ch.uzh.ifi.seal.product.model.Product;

import java.util.Set;

public class AdvertisementController {
    private final AdvertisementPageService advertisementPageService;
    private final CustomerService customerService;

    public AdvertisementController() {
        this.advertisementPageService = new AdvertisementPageService();
        this.customerService = new CustomerService();
    }

    public void createTheUltimateAdvertisement(Product product) {
        //First we want to design a nice advertisement page in our shop and make it available online
        AdvertisementPage advertisementPage = advertisementPageService.createNewAdvertisementPage(product);
        advertisementPage.makeVisibleInShop();

        //Next step is to send some spam mails to our customers
        Set<Customer> customers = customerService.loadCustomers();
        
        //Annoying Youtube Spots are also a great idea so let us create some, customers gonna love 'em

        //Customers always want to make a good deal so we offer them one but we limit the quantity

    }
}
