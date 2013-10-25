package com.extended.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 
 * @version 1.0.0
 *          </p>
 * 
 *          <p>
 *          This Class extends the functionality provided by apache's
 *          {@link org.apache.commons.lang3.StringUtils}. This class provides
 *          all the functionality of apache's StringUtils with some of its own
 *          features. This class has been tested on Oracle's JDK1.6.0_38
 *          compiler.
 *          </p>
 * 
 *          <p>
 *          In current version 1.0.0 we are providing extra features on String
 *          in thread safe manner.
 *          </p>
 * 
 *          <p>
 *          For any issues/bugs/suggestions/feedbacks or any further needed
 *          functionality please drop a mail to author at
 *          {@link aggarwal_gaurav04@yahoo.co.in}. We will be pleased to hear
 *          any constructive feedbacks.
 * 
 * @author Gaurav Aggarwal
 *         </p>
 * 
 */
public class StringUtil extends StringUtils {

	/**
	 * <p>
	 * This function takes a String and remove all the white spaces from the
	 * text. This function is different from {@link java.lang.Srting} trim()
	 * method as it remove all the white spaces not just from borders.
	 * </p>
	 * <p>
	 * 
	 * @param text
	 *            String The text from that all white spaces needs to be
	 *            removed.
	 * @return String The text with removed white spaces.
	 *         </p>
	 */
	public static String removeAllWhiteSpace(String text) {
		synchronized (text) {
			if (isNotEmpty(text)) {
				return text.replaceAll("[\\s]", "");
			}
			return text;
		}

	}

	/**
	 * <p>
	 * This function returns all the words present in String parameter passed to
	 * it in String array. The default word separator used in function is white
	 * space.
	 * </p>
	 * <p>
	 * If another word separator needs to be used please use the overloaded
	 * function provided to pass the word separator with it.
	 * </p>
	 * <p>
	 * 
	 * @param text
	 *            {@link java.lang.String} The text from which words would get
	 *            separated.
	 * @return Array of {@link java.lang.String}[] containing all words
	 *         separated by white space from the text.
	 *         </p>
	 */
	public static String[] getWordsSeperated(String text) {
		return getWordsSeperated(text, "[\\s]");
	}

	/**
	 * <p>
	 * This function returns all the words present in String parameter passed to
	 * it in String array. If null is passed the default word separator used in
	 * function is white space.
	 * </p>
	 * <p>
	 * 
	 * @param text
	 *            {@link java.lang.String} The text from which words would get
	 *            separated.
	 * 
	 * @param wordSeperator
	 *            {@link java.lang.String} The word seperator that is used to
	 *            separate words in text from which words would get separated.
	 * @return Array of {@link java.lang.String}[] containing all words
	 *         separated by white space from the text.
	 *         </p>
	 */
	public static String[] getWordsSeperated(String text, String wordSeperator) {
		synchronized (text) {
			if (isNotEmpty(text)) {
				text = text.trim().replaceAll("[\\.]|[!]|[\\?]|[,]", " ");
				String[] words = null;
				if (null != wordSeperator) {
					words = text.split(wordSeperator);
				} else {
					words = text.split("[\\s]");
				}
				List<String> result = new ArrayList<String>();
				for (String word : words) {
					if (isNotEmpty(word)) {
						result.add(word);

					}
				}
				return CollectionUtil.toArray(result, String.class);
			}
			return new String[] { text };
		}
	}

	/**
	 * <p>
	 * The function to replace the find text with replace text by matching the
	 * find text in given text without considering case of find text in text or
	 * in finding pattern.
	 * </p>
	 * <p>
	 * 
	 * @param toFind
	 *            {@link java.lang.String} the Text that needs to be find and
	 *            replace.
	 * @param toRepalce
	 *            {@link java.lang.String} the Text that will replace the find
	 *            text.
	 * @param text
	 *            {@link java.lang.String} the Text from which text would be
	 *            searched and replace.
	 * @return {@link java.lang.String} the Text with replaced String.
	 *         </p>
	 */
	public static String replaceIgnoreCase(String toFind, String toRepalce,
			String text) {
		if (isNotEmpty(text) && containsIgnoreCase(text, toFind)) {
			String regex = createRegexForReplace(toFind);
			System.out.println(regex);
			text = text.replaceAll(regex, toRepalce);
		}
		return text;
	}

	private static String createRegexForReplace(String toFind) {
		char[] find = toFind.toCharArray();
		StringBuilder regexString = new StringBuilder();
		for (char f : find) {
			int d = f;
			if ((d >= 65 && d <= 90) || (d >= 97 && d <= 122)) {
				regexString.append("[");
				regexString.append(Character.toString((char) d));
				int temp = d;
				if (Character.isLowerCase(f)) {
					temp = d - 32;
				} else {
					temp = d + 32;
				}
				regexString.append(Character.toString((char) temp));
				regexString.append("]");
			} else if (d == 32) {

				regexString.append("[\\s]");
			} else {
				regexString.append("[");
				regexString.append(f);
				regexString.append("]");
			}
		}
		return regexString.toString();
	}
}
