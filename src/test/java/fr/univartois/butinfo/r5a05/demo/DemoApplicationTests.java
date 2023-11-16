package fr.univartois.butinfo.r5a05.demo;

import fr.univartois.butinfo.r5a05.demo.repository.AnnuaireRepository;
import fr.univartois.butinfo.r5a05.demo.service.CharacterService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.when;
import java.util.Objects;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@Autowired
	private CharacterService bibilothequeService;

	@Autowired
	private AnnuaireRepository annuaireRepository;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private BibilothequeExterneService bibilothequeExterneService;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void initDb() {
		final var annuaire = new Annuaire();
		annuaire.setId("test");
		annuaireRepository.save(annuaire);
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDownDb() {
		annuaireRepository.deleteAll();
	}

	@Test
	void testCreateAnnuaire() {
		bibilothequeService.createAnnuaire("test2");
		Assertions.assertNotNull(annuaireRepository.findById("test2").orElse(null));
	}

	@Test
	void testGetAnnuaire() {
		final var ann = new Annuaire();
		ann.setId("5");
		final var response = new ResponseEntity<>(ann, HttpStatusCode.valueOf(200));
		when(restTemplate.getForEntity("http://service-externe.fr/annuaire/5", Annuaire.class)).thenReturn(response);
		final var annuaire = bibilothequeExterneService.getAnnuaire("5");
		Assertions.assertEquals("5", annuaire.getId());

	}

	@Test
	void testAddToAnnuaire() {
		var personne = new Personne();
		personne.setId(1);
		bibilothequeService.addToAnnuaire("test", personne);
		Assertions.assertEquals(Objects.requireNonNull(annuaireRepository.findById("test").orElse(null)).getPersonnes().size(), 1);
	}

}
