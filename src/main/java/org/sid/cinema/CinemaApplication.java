package org.sid.cinema;


import org.sid.cinema.entities.Film;
import org.sid.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication(scanBasePackages={"org.sid.cinema.service","org.sid.cinema.entities","org.sid.cinema"}) 
public class CinemaApplication implements CommandLineRunner { 
    @Autowired
	private ICinemaInitService cinemaInitService;
    @Autowired
	private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		restConfiguration.exposeIdsFor(Film.class);
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initfilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
	}

}
