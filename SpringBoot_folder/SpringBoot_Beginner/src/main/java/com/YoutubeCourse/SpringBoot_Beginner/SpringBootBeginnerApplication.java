package com.YoutubeCourse.SpringBoot_Beginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringBootBeginnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeginnerApplication.class, args);
	}

//	依賴注入 CustomerRepository Interface: 將B在外部實例化後再傳入A，也就是將B當成參數傳入A。
	public final CustomerRepository customerRepository;

	public SpringBootBeginnerApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
// Read
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

	record NewCustomerRequest(
			String name,
			String email,
			Integer age
	){};
//	Create
	@CrossOrigin(origins = "*")
	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}
// Update
	@CrossOrigin(origins = "*")
	@PutMapping("{customerId}")
	public void updateCustomer(@PathVariable("customerId") Integer Id,@RequestBody NewCustomerRequest request) throws ChangeSetPersister.NotFoundException {
		Customer customer = customerRepository.findById(Id)
						.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}
//Delete
	@CrossOrigin(origins = "*")
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) { //透過 id 刪除
		customerRepository.deleteById(id);
	}
}
