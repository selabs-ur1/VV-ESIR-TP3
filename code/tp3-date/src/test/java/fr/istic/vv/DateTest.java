package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

	private Date Bonnedate;
	//ne respectant pas la longueur des mois 
	//par exemple 31 avril
	private Date faussedate1;
	//ne respectant pas le nombre de jours des mois
	private Date  faussedate2;
	//ne respectant pas le format
	private Date mauvaisFormat;
	protected void setUp() throws Exception {
		Bonnedate=new Date(23,03,2022);
		faussedate1=new Date(31,04,2025);
		faussedate1=new Date(35,05,2023);
		mauvaisFormat=new Date(05,30,2022);
		}
	@Test
	public void testBonnedate() {
		int day=Bonnedate.getDay();
		int month=Bonnedate.getMonth();
		int year=Bonnedate.getYear();
		assertTrue(Bonnedate.isValidDate(day,month,year));
	}
	@Test
	public void testfaussedate1() {
		int day=faussedate1.getDay();
		int month=faussedate1.getMonth();
		int year=faussedate1.getYear();
		assertFalse(faussedate1.isValidDate(day,month,year));
	}
	@Test
	public void testfaussedate2() {
		int day=faussedate2.getDay();
		int month=faussedate2.getMonth();
		int year=faussedate2.getYear();
		assertFalse(faussedate2.isValidDate(day,month,year));
	}
	@Test
	public void testmauvaisFormat() {
		int day=mauvaisFormat.getDay();
		int month=mauvaisFormat.getMonth();
		int year=mauvaisFormat.getYear();
		assertFalse(mauvaisFormat.isValidDate(day,month,year));
	}
	
}