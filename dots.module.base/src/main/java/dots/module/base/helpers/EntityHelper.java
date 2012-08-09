package dots.module.base.helpers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EntityHelper {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Object> T entityToBean(Object sourceObj,
			Class targetClass) {

		if (sourceObj == null || targetClass == null) {
			return null;
		}

		// get the class of the source object
		Class sourceObjClass = sourceObj.getClass();

		// instance of the target class
		T targetObj = null;

		try {

			// create an instance of the target class
			targetObj = (T) targetClass.newInstance();

			// loop through the source class hierarchy
			while (true) {

				// get the fields in the current class in the hierarchy
				Field[] sourceFields = sourceObjClass.getDeclaredFields();

				// copy fields to the target object
				for (Field sourceField : sourceFields) {

					if (sourceField.getType() != String.class
							&& sourceField.getType() != Integer.class
							&& sourceField.getType() != Long.class
							&& sourceField.getType() != Date.class) {

						continue;
					}

					Field targetField = targetClass
							.getDeclaredField(sourceField.getName());
					targetField.setAccessible(true);
					sourceField.setAccessible(true);
					targetField.set(targetObj, sourceField.get(sourceObj));
				}

				// more classes in the hierarchy
				if (sourceObjClass.getSuperclass() != null) {
					sourceObjClass = sourceObjClass.getSuperclass();
				}
				// top of the hierarchy
				else {
					break;
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return targetObj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Object> List<T> entitiesToBeans(
			Collection sourceObjects, Class targetClass) {

		if (sourceObjects == null || targetClass == null) {
			return new ArrayList<T>();
		}

		List<T> targetObjects = new ArrayList<T>();

		Iterator iter = sourceObjects.iterator();

		while (iter.hasNext()) {

			Object sourceObject = iter.next();

			Object targetObject = entityToBean(sourceObject, targetClass);

			if (targetObject == null) {
				continue;
			}

			targetObjects.add((T) targetObject);
		}

		return targetObjects;
	}

}
