/**
 * 
 */
package com.extended.common.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

/**
 * <p>
 * 
 * @version 1.0.0
 *          </p>
 * 
 *          <p>
 *          This Class extends the functionality provided by apache's
 *          {@link org.apache.commons.lang3.ArrayUtils}. This class provides all
 *          the functionality of apache's ArrayUtils with some of its own
 *          features. This class has been tested on Oracle's JDK1.6.0_38
 *          compiler.
 *          </p>
 * 
 *          <p>
 *          In current version 1.0.0 we are providing extra features only on
 *          Object type single dimensional arrays. Primitive type and
 *          multidimensional arrays will be supported in further releases.
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
public class ArrayUtil extends ArrayUtils {

	/**
	 * <p>
	 * Convert an array into {@link java.util.List} of same length.
	 * Multidimensional arrays are not supported.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            the array of any object type.
	 * @return {@code null} if array is empty or {@code null} else
	 *         {@link java.util.List}
	 *         </p>
	 */
	public static <E> List<E> toList(E[] array) {
		if (isNotEmpty(array)) {
			List<E> result = new ArrayList<E>(array.length);
			for (E val : array) {
				result.add(val);
			}
			return result;
		}
		return null;
	}

	/**
	 * <p>
	 * This function provides the functionality of converting an array into a
	 * List based on some condition provided in Comparator that can be passed as
	 * a parameter by caller.
	 * 
	 * Caller has the complete control over the condition by which the selection
	 * would be made to make an element eligible for entry in result.
	 * </p>
	 * <p>
	 * Convert the array into {@link java.util.List} based on
	 * {@link java.util.Comparator<E>} comparison's result. An element of array
	 * would be added to result if and only if comparator's compare method
	 * return value greater than or equal to zero. Multidimensional arrays are
	 * not supported.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            the array of any object type.
	 * @param {@link java.util.Comparator<E>} comparator to decide the
	 *        eligibility condition.
	 * @param forCompare
	 *            element against which comparison would be made for determining
	 *            the eligibility .
	 * @return {@code null} if array is empty or {@code null} else
	 *         {@link java.util.List}
	 *         </p>
	 */
	public static <E> List<E> toList(E[] array, Comparator<E> comp, E forCompare) {
		if (isNotEmpty(array)) {
			List<E> result = new ArrayList<E>();
			for (E val : array) {
				if (comp.compare(forCompare, val) >= 0) {
					result.add(val);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * <p>
	 * This function provides the functionality of converting an array into a
	 * List based on some condition provided in elements of array.
	 * 
	 * If element of array is of {@link java.lang.Comparable} type then the
	 * compare function of the element's class decides the condition by which
	 * the selection would be made to make an element eligible for entry in
	 * result.
	 * </p>
	 * <p>
	 * Convert the array into {@link java.util.List} based on
	 * {@link java.lang.Comparable} comparison's result. An element of array
	 * would be added to result if and only if Comparable's compareTo method
	 * return value greater than or equal to zero. Multidimensional arrays are
	 * not supported.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            the array of any object type.
	 * @param forCompare
	 *            element against which comparison would be made for determining
	 *            the eligibility .
	 * @return {@code null} if array is empty or {@code null} else
	 *         {@link java.util.List}
	 *         </p>
	 */
	public static <E extends Comparable<E>> List<E> toList(E[] array,
			E forCompare) {
		if (isNotEmpty(array)) {
			List<E> result = new ArrayList<E>();
			for (E val : array) {
				if (val.compareTo(forCompare) >= 0) {
					result.add(val);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * <p>
	 * Convert an array into {@link java.util.Set} of same length and in Same
	 * order. This function maintains the order of element is Set same as in
	 * Array. Multidimensional arrays are not supported.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            the array of any object type.
	 * @return {@code null} if array is empty or {@code null} else
	 *         {@link java.util.Set}
	 *         </p>
	 */
	public static <E> Set<E> toSet(E[] array) {
		if (isNotEmpty(array)) {
			Set<E> result = new LinkedHashSet<E>(array.length);
			for (E val : array) {
				result.add(val);
			}
			return result;
		}
		return null;
	}

	/**
	 * <p>
	 * This function provides the functionality of converting an array into a
	 * Set based on some condition provided in elements of array.The order of
	 * element in result would be same as of array.
	 * 
	 * If element of array is of {@link java.lang.Comparable} type then the
	 * compare function of the element's class decides the condition by which
	 * the selection would be made to make an element eligible for entry in
	 * result.
	 * </p>
	 * <p>
	 * Convert the array into {@link java.util.Set} based on
	 * {@link java.lang.Comparable} comparison's result. An element of array
	 * would be added to result if and only if Comparable's compareTo method
	 * return value greater than or equal to zero.The order of element in result
	 * would be same as of array. Multidimensional arrays are not supported.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            the array of any object type.
	 * @param forCompare
	 *            element against which comparison would be made for determining
	 *            the eligibility .
	 * @return {@code null} if array is empty or {@code null} else
	 *         {@link java.util.Set}
	 *         </p>
	 */
	public static <E extends Comparable<E>> Set<E> toSet(E[] array, E forCompare) {
		if (isNotEmpty(array)) {
			Set<E> result = new LinkedHashSet<E>();
			for (E val : array) {
				if (val.compareTo(forCompare) >= 0) {
					result.add(val);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * <p>
	 * This function provides the functionality of converting an array into a
	 * {@link java.util.Set} based on some condition provided in Comparator that
	 * can be passed as a parameter by caller.The order of element in result
	 * would be same as of array.
	 * 
	 * Caller has the complete control over the condition by which the selection
	 * would be made to make an element eligible for entry in result.
	 * </p>
	 * <p>
	 * Convert the array into {@link java.util.Set} based on
	 * {@link java.util.Comparator<E>} comparison's result. An element of array
	 * would be added to result if and only if comparator's compare method
	 * return value greater than or equal to zero. The order of element in
	 * result would be same as of array. Multidimensional arrays are not
	 * supported.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            the array of any object type.
	 * @param {@link java.util.Comparator<E>} comparator to decide the
	 *        eligibility condition.
	 * @param forCompare
	 *            element against which comparison would be made for determining
	 *            the eligibility .
	 * @return {@code null} if array is empty or {@code null} else
	 *         {@link java.util.Set}
	 *         </p>
	 */
	public static <E> Set<E> toSet(E[] array, Comparator<E> comp, E forCompare) {
		if (isNotEmpty(array)) {
			Set<E> result = new LinkedHashSet<E>();
			for (E val : array) {
				if (comp.compare(forCompare, val) >= 0) {
					result.add(val);
				}
			}
			return result;
		}
		return null;
	}

	/**
	 * <p>
	 * Function to find and replace the particular value from array.
	 * </p>
	 * <p>
	 * This function uses the equals method of elements of array to find the
	 * element in array. Caller needs to ensure the proper equals method for
	 * proper functioning of this method. Caller can control to replace all or
	 * the first instance of match in array.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            on which find and replace would be performed.
	 * @param toFind
	 *            the element which need to be find in Array.
	 * @param toReplace
	 *            the element that would replace the match at same position in
	 *            array.
	 * @param replaceAll
	 *            boolean if true all the matches would be replaced in array
	 *            else only first instance would get replaced.
	 * @return boolean true if and only if at least one value gets matched in
	 *         array else false.
	 *         </p>
	 */
	public static <E> boolean findAndReplace(E[] array, E toFind, E toReplace,
			boolean replaceAll) {
		boolean result = false;
		if (isNotEmpty(array)) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(toFind)) {
					array[i] = toReplace;
					result = true;
					if (!replaceAll) {
						return result;
					}
				}
			}
			return result;
		}
		return result;
	}

	/**
	 * <p>
	 * Function to find and replace the particular value from array.
	 * </p>
	 * <p>
	 * This function uses the equals method of elements of array to find the
	 * element in array. Caller needs to ensure the proper equals method for
	 * proper functioning of this method. Caller can control the count of
	 * replaces in array.
	 * </p>
	 * <p>
	 * 
	 * @param array
	 *            on which find and replace would be performed.
	 * @param toFind
	 *            the element which need to be find in Array.
	 * @param toReplace
	 *            the element that would replace the match at same position in
	 *            array.
	 * @param replaceCount
	 *            int the count of matches that Caller wants to get replaced.
	 * @return boolean true if and only if at least one value gets matched in
	 *         array else false.
	 *         </p>
	 */
	public static <E> boolean findAndReplace(E[] array, E toFind, E toReplace,
			int replaceCount) {
		boolean result = false;
		if (isNotEmpty(array)) {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(toFind)) {
					array[i] = toReplace;
					result = true;
					count++;
					if (count == replaceCount) {
						return result;
					}
				}
			}
			return result;
		}
		return result;
	}
}
