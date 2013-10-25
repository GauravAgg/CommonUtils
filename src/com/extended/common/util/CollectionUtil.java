package com.extended.common.util;

import java.lang.reflect.Array;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

/**
 * <p>
 * 
 * @version 1.0.0
 *          </p>
 * 
 *          <p>
 *          This Class extends the functionality provided by apache's
 *          {@link org.apache.commons.collections.CollectionUtils}. This class
 *          provides all the functionality of apache's CollectionUtils with some
 *          of its own features. This class has been tested on Oracle's
 *          JDK1.6.0_38 compiler.
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
public class CollectionUtil extends CollectionUtils {

	/**
	 * <p>
	 * This function converts the Collection type into Array of same type as of
	 * collection's element type.
	 * </p>
	 * 
	 * @param {@link java.util.Collection} collection The collection to get
	 *        converted to array.
	 * @param {@link java.lang.Class} classType The Class type of elements
	 *        present in Collection.
	 * @return Array of elements present in Collection.
	 */
	public static <E> E[] toArray(Collection<E> collection, Class<E> classType) {
		if (isNotEmpty(collection)) {
			@SuppressWarnings("unchecked")
			E[] result = (E[]) Array.newInstance(classType, collection.size());
			result = collection.toArray(result);
			return result;
		}
		return null;
	}

}
