package reflect.first;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MAP转换工具类
 */
public class MapUtil {

    private static final Logger logger = LoggerFactory.getLogger(MapUtil.class);

    /**
     * 转换为Collection<Map>
     * 
     * @param collection 待转换对象集合
     * @return 转换后的Collection<Map>
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("rawtypes")
    public static Collection<Map> toMapList(Collection collection)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<Map> retList = new ArrayList<Map>();
        if (collection != null && !collection.isEmpty()) {
            for (Object object : collection) {
                Map<String, Object> map = new HashMap<String, Object>();
                toMap(object.getClass(), object, map);
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 对象转Map,但不提供字段名转换
     * 
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Map<String, Object> toMap(Object object)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String, Object> map = new HashMap<String, Object>();
        toMap(object.getClass(), object, map);
        return map;
    }

    /**
     * 获取最相似的主键对应的值
     * 
     * @param searchKey
     * @param map
     * @return
     */
    public static <T> T getKeyMostStartWithValue(String searchKey, Map<String, T> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String mostLikeKey = null;
        for (String oneKey : map.keySet()) {
            if (searchKey.startsWith(oneKey) && (mostLikeKey == null || oneKey.length() > mostLikeKey.length())) {
                mostLikeKey = oneKey;
            }
        }
        if (mostLikeKey != null) {
            return map.get(mostLikeKey);
        } else {
            return null;
        }
    }

    /**
     * 对象转Map,但不提供字段名转换
     * 
     * @param clazz 目标对象所在类
     * @param object 目标对象
     * @param map 待转换Map
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static void toMap(Class<?> clazz, Object object, Map<String, Object> map)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                String fieldName = fields[i].getName();
                if ("serialVersionUID".equals(fieldName)) {
                    continue;
                }
                String fieldValue = null;
                try {
                    fieldValue = BeanUtils.getProperty(object, fieldName);
                    if (fieldValue != null) {
                        map.put(fieldName, fieldValue);
                    }
                } catch (Exception e) {
                    logger.warn(clazz + "获取属性" + fieldName + "的值失败", e);
                    continue;
                }
            }
        }
        if (clazz.getSuperclass() != null) {
            toMap(clazz.getSuperclass(), object, map);
        }
    }

}
