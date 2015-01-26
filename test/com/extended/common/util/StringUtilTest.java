/**
 * 
 */
package com.extended.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Gaurav Agg.
 *
 */
public class StringUtilTest {

	/**
	 * Test method for {@link com.extended.common.util.StringUtil#removeAllWhiteSpace(java.lang.String)}.
	 */
	@Test
	public void testRemoveAllWhiteSpace() {
		String result=StringUtil.removeAllWhiteSpace("Gaurav Agga ");
		assertEquals("GauravAgga", result);
	}
	
	/**
	 * Test method for {@link com.extended.common.util.StringUtil#getWordsSeperated(java.lang.String)}.
	 */
	@Test
	public void testgetWordsSeperated() {
		String[] result=StringUtil.getWordsSeperated("Gaurav is,so, good?",null);
		assertEquals(4, result.length);
		assertEquals("good", result[3]);
	}

	@Test
	public void testreplaceIgnoreCase(){
		String text=StringUtil.replaceIgnoreCase("is,So", "is So", "Gaurav iS,SO good");
		assertEquals("Gaurav is So good", text);
	}
}
