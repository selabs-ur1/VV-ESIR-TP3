package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class StringUtilsTest {
	
	private String [] Bonnereponse;
	private String [] separateurImbriqué;
	private String [] manqueseparatuer;
	
@BeforeEach
protected void setUp() throws Exception {
	//nous avons séparé les entrées en trois tableaux selon les spécificités des entrées
	//ainsi le tableau balanced string sont les balanced String, le tableau separateurImbrique représente les chaines 
	//avec des parenthéses ou des crochets qui s'imbriquent
	//le tableau manqueseparateur représente les chaines de caractére où il manque une parenthése fermante ou ouvrante
	Bonnereponse= new String[3];
	separateurImbriqué= new String[3];
	manqueseparatuer = new String[3];
	}
@Test
public void testBonnereponse() {
	Bonnereponse[0]="{hevfdkjdfk}";
	Bonnereponse[1]="{[[[[]]]]}";
	Bonnereponse[2]="{[[oofqsddfs()]]}";
	int TrueCount=0;
	for(int i=0;i<=2;i++) {
		if(isBalanced(Bonnereponse[i])) {
			TrueCount++;
		}
	}
	assertTrue(TrueCount==3);
	
}
//teste si notre programme marche correctement sur les bonnes réponses 
@Test
public void TestMauvaisAlignement(){
	separateurImbriqué[0]="[sdcds{]qrfvdfd}}";
	assertFalse(isBalanced(separateurImbriqué[0]));
}
//teste si notre programme detecte les injections de bugs
@Test
public void TestMauvaisereponse() 
{
	manqueseparatuer[0]="{lfjdvlfsn[()(('";
	assertFalse(isBalanced(manqueseparatuer[0]));
}
}