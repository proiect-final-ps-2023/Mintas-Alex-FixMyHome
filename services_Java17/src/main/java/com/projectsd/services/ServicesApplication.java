package com.projectsd.services;


import com.projectsd.services.model.Customer;
import com.projectsd.services.model.Worker;
import com.projectsd.services.repository.CustomerRepository;
import com.projectsd.services.repository.WorkerRepository;
import com.projectsd.services.service.implementation.WorkerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;

import static com.projectsd.services.enumeration.Housing.*;
import static com.projectsd.services.enumeration.Job.*;

@SpringBootApplication
public class ServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner run(WorkerRepository workerRepository, CustomerRepository customerRepository, WorkerService workerService) {
        return args -> {
            workerRepository.save(new Worker("Alex", "Mintas", "alexmintas@yahoo.ro", "0740933344", LocalDate.of(2002, 6, 20), TileSetter));
            workerRepository.save(new Worker("Oana", "Morar", "oanamorar@yahoo.ro", "0740344521", LocalDate.of(2001, 3, 18), Locksmith));
            workerRepository.save(new Worker("Mihai", "Mic", "mihaimic@yahoo.ro", "0726977211", LocalDate.of(1998, 1, 30), Plumber));
            workerRepository.save(new Worker("Cristina", "Titu", "cristinatitu@yahoo.ro", "0730946454", LocalDate.of(2001, 5, 26), Electrician));
            workerRepository.save(new Worker("Tomas", "Nicoara", "tomasnicoara@yahoo.ro", "0733245489", LocalDate.of(2000, 10, 12), Electrician));
            workerRepository.save(new Worker("Ciprian", "Negrut", "cipriannegrut@yahoo.ro", "0778261033", LocalDate.of(2002, 1, 30), Painter));
            workerRepository.save(new Worker("Carina", "Morar", "carinamorar@yahoo.ro", "0766298300", LocalDate.of(2003, 5, 31), TileSetter));
            workerRepository.save(new Worker("Dorian", "Popa", "dorianpopa@yahoo.ro", "0748334522", LocalDate.of(1990, 7, 19), Plumber));
            workerRepository.save(new Worker("John", "Doe", "johndoe@yahoo.ro", "0785443356", LocalDate.of(1964, 2, 14), Painter));
            workerRepository.save(new Worker("Ioachim", "Sotan", "ioachimsotan@yahoo.ro", "0796694511", LocalDate.of(2000, 4, 6), TileSetter));
            workerRepository.save(new Worker("Cristiano", "Ronaldo", "cr7@yahoo.ro", "0736445657", LocalDate.of(1985, 2, 5), Plumber));
            workerRepository.save(new Worker("Kylian", "Mbappe", "kylianmbappe@yahoo.ro", "0795234491", LocalDate.of(1998, 12, 20), Painter));

            customerRepository.save(new Customer("Alex", "Mintas", "alexmintas@yahoo.ro", "0740933344", LocalDate.of(2002, 6, 20), Apartment));
            customerRepository.save(new Customer("Oana", "Morar", "oanamorar@yahoo.ro", "0740344521", LocalDate.of(2001, 3, 18), Apartment));
            customerRepository.save(new Customer("Mihai", "Mic", "mihaimic@yahoo.ro", "0726977211", LocalDate.of(1998, 1, 30), Mansion));
            customerRepository.save(new Customer("Cristina", "Titu", "cristinatitu@yahoo.ro", "0730946454", LocalDate.of(2001, 5, 26), House));
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
