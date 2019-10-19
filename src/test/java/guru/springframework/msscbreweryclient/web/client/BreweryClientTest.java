package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		
		URI uri = client.saveNewBeer(beerDto);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	 void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		
		client.updateBeer(UUID.randomUUID(), beerDto);
	 }
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
	
	//********** Test Customers ******************//
	@Test
	void getCustomerById() {
		CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
		assertNotNull(customerDto);
	}
	
	@Test
	void testSaveNewCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("Ahmet").build();
		URI uri = client.saveNewCustomer(customerDto);
		
		assertNotNull(uri);
	}
	
	@Test
	void testUpdateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("Ahmet").build();
		client.updateCustomer(UUID.randomUUID(), customerDto);
	}
	
	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}
	
	
}
