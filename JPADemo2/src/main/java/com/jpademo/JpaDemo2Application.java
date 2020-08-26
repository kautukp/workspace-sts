package com.jpademo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jpademo.entities.CD;
import com.jpademo.entities.Musicians;
import com.jpademo.repositories.CDRepository;
import com.jpademo.repositories.MusicianRepository;

@ComponentScan(basePackages = { "com.jpademo.repositories.*", "com.jpademo.entities.*" })
@SpringBootApplication
public class JpaDemo2Application {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(JpaDemo2Application.class, args);
		MusicianRepository musicianRepo = context.getBean(MusicianRepository.class);
		CDRepository cdRepo = context.getBean(CDRepository.class);

		Musicians musician1 = new Musicians(101, "Lata Mangeshkar");
		Musicians musician2 = new Musicians(102, "Sonu Nigam");
		Musicians musician3 = new Musicians(103, "Arijit Singh");
		musicianRepo.save(musician1);
		musicianRepo.save(musician2);
		musicianRepo.save(musician3);

		Optional<Musicians> musicianByID = musicianRepo.findById(101);
		if (musicianByID.isPresent()) {
			System.out.println("musicianByID-> " + musicianByID.get());
		}

		Iterable<Musicians> allMusicians = musicianRepo.findAll();
		for (Musicians musicians : allMusicians) {
			System.out.println(musicians);
		}

		Optional<Musicians> musicianListStartingWith = musicianRepo.findByNameStartingWith("Sonu");
		if (musicianListStartingWith.isPresent()) {
			System.out.println("musicianListStartingWith-> " + musicianListStartingWith.get().getName());
		}

		/****************************/

		CD cd1 = new CD(11, "English", "Emotional", 90.00, musician3);
		CD cd2 = new CD(12, "Hindi", "Drama", 100.00, musician1);
		CD cd3 = new CD(13, "Marathi", "Love", 125.00, musician1);
		CD cd4 = new CD(14, "Hindi", "Drama", 150.00, musician2);

		cdRepo.save(cd1);
		cdRepo.save(cd2);
		cdRepo.save(cd3);
		cdRepo.save(cd4);

		List<CD> cdTitleList = cdRepo.findByTitleIgnoreCase("english");
		System.out.println("CD Title -> " + cdTitleList);

		List<CD> cdListByUnitCost = cdRepo.findByUnitCostGreaterThan(100.00);
		System.out.println("CD By UnitCost -> " + cdListByUnitCost);

	}

}
