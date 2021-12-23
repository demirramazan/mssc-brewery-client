package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BreweryClientTest {
    @Autowired
    private BreweryClient breweryClient;

    @Test
    public void getById() {
        BeerDto beerDto = breweryClient.getById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    public void saveBeer() {
        URI uri = breweryClient.saveBeer(BeerDto.builder().beerName("new beer").build());
        assertNotNull(uri);
        System.out.println("uri = " + uri);
    }

    @Test
    public void updaterBeer() {
       breweryClient.updateBeer(UUID.randomUUID(),BeerDto.builder().beerName("update beer").build());
    }

    @Test
    public void deleteBeer(){
        breweryClient.deleteBeerById(UUID.randomUUID());
    }

    @Test
    public void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    public void saveNewCustomer() {
        URI uri = breweryClient.saveNewCustomer(CustomerDto.builder().name("new customer").build());
        assertNotNull(uri);
        System.out.println("uri = " + uri);
    }
    @Test
    public void updateCustomer() {
        breweryClient.updateCustomer(UUID.randomUUID(),CustomerDto.builder().name("update customer name").build());
    }

    @Test
    public void deleteCustomer(){
        breweryClient.deleteCustomerById(UUID.randomUUID());
    }
}