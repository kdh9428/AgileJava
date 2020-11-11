package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx1 {

    public static void main(String[] args) throws Exception {
        System.out.println("====================== Class Information ===================");
        Class<?> cls = Class.forName("Reflection.ReflectTest");

        Field[] fields = cls.getFields();

        for (Field field : fields) {
            System.out.println(field.getType().getName() + " : " + field.getName());
        }

        System.out.println("====================== Method Information ===================");

        Method[] methods = cls.getMethods();

        StringBuilder builder = new StringBuilder();

        for (Method method : methods) {
            builder.append(method.getName());

            Class<?>[] parameterTypes = method.getParameterTypes();
            builder.append("(");
            int size = parameterTypes.length;
            for (Class<?> parameterType : parameterTypes) {
                String parameterName = parameterType.getName();
                builder.append(parameterName + " val");

                if (--size != 0) {
                    builder.append(", ");
                }
            }
            builder.append(")");

            Class<?> returnType = method.getReturnType();
            builder.append(" : " + returnType.getName());

            System.out.println(builder.toString());
            builder.delete(0, builder.length());
        }

        System.out.println("====================== Use the reflection method ===================");

        Object object = cls.getDeclaredConstructor().newInstance();

        Method method = cls.getMethod("sum", int.class, int.class);
        System.out.println(method.invoke(object, 1, 2));

        Class[] param = {int.class, int.class};
        method = cls.getMethod("sum", param);
        System.out.println(method.invoke(object, 5, 2));

        method = cls.getMethod("sum", new Class[]{int.class, int.class});
        System.out.println(method.invoke(object, new Object[]{1, 5}));

        method = cls.getMethod("sub", int.class, int.class);

        System.out.println(method.invoke(null, 3, 1));

        System.out.println(method.invoke(object, 3, 1));
        System.out.println(method.invoke(cls, 3, 1));


        method = cls.getMethod("getArrayList", (Class<?>[]) null);
        method.invoke(object);
        method = cls.getMethod("getArrayList");
        method.invoke(object);

        method = cls.getMethod("getArrayList", new Class[]{int.class});
        method.invoke(object, new Object[]{1});

        ReflectTest reflectTest = (ReflectTest) object;
        System.out.println(reflectTest.sum(5, 2));
        System.out.println(reflectTest.sub(5, 2));
        System.out.println(ReflectTest.sub(5, 2));

    }
}
