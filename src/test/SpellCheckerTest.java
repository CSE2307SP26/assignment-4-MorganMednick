package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void numWords() {//A spellchecker should be able to tell us how many words it currently knows about
		//Make objects to be tested
		SpellChecker checker = new SpellChecker();

		//2. call the method being tested
		int words = checker.getNumberOfWords();
		fail("Not yet implemented");

		//3. Assertions to verify
		assertEquals(0, words);
	}
//The number of words a spellchecker knows about should go up by one whenever a new word is added
@Test
void newWordCount() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	int pre = checker.getCount();
	checker.add("Word");
	int post = checker.getCount();

	//3. Assertions to verify
	assertEquals(pre+1==post, true);
}
//If a word is added that is already contained in the spellchecker, then the number of words contained in the spellchecker should not change
@Test
void usedWord() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("Word");
	int pre = checker.getCount();
	checker.add("Word");
	int post = checker.getCount();

	//3. Assertions to verify
	assertEquals(pre==post, true);
}
//A spellchecker should be able to accept a properly spelled word and return an indication that it is properly spelled
@Test
void spellCheck() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("Word");
	int check = checker.check(); //Checks an entire list of words, returns the index of any misspelt words, or -1 if none

	//3. Assertions to verify
	assertEquals(check, -1);
}

//A spellchecker should be able to accept an improperly spelled word and return an indication that it is improperly spelled
@Test
void misspeltWord() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("missspell");
	int check = checker.check(); //Checks the entire list of words, returns the index of any misspelt words, or -1 if none

	//3. Assertions to verify
	assertEquals(check, 0);
}

//A spellchecker should ignore case when checking how words are spelled (i.e. "cat" and "CaT" are both properly spelled as long as "cat" (or "Cat" or "caT", etc.) appears in our spellchecker.

@Test
void caseCheck() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("caT");
	checker.add("CAT");
	checker.add("CaT");

	int check = checker.check();

	//3. Assertions to verify
	assertEquals(check, -1);
}

//A spellchecker should be able to recommend a properly spelled word for any String that it is given. In other words, if I were to input the String "bamk", the spell checker could suggest that the word "bank" is properly spelled, meaning that the word "bank" is the alphabetically closest word in the spellchecker to the given String "bamk"
@Test
void recommendAbple() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("aples");

	int check = checker.check();
	String rec = checker.reccommend(check);

	//3. Assertions to verify
	assertEquals(rec, "apples");
}

//If we ask the spellchecker to suggest a properly spelled word for a String that is already properly spelled, it should simply return the original word.
@Test
void recommendApple() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("apples");

	int check = checker.check();
	String rec = checker.reccommend(check);

	//3. Assertions to verify
	assertEquals(rec, "apples");
}

//MY OWN: Count should not increase with different cases
@Test
void caseCount() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("caT");
	checker.add("CAT");
	checker.add("CaT");

	int count = checker.getCount();

	//3. Assertions to verify
	assertEquals(count, 1);
}

//MY OWN 2: remove() should remove misspelt words
@Test
void removeWords() {
	//Make objects to be tested
	SpellChecker checker = new SpellChecker();

	//2. call the method being tested
	checker.add("cat");
	checker.add("2at");
	checker.add("dog");

	int check = checker.check();
	checker.remove(check);

	int count = checker.getCount();

	//3. Assertions to verify
	assertEquals(count, 2);
}
	

}
