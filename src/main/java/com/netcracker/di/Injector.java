package com.netcracker.di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Configuration(packages = {"com.netcracker.contractSorter", "com.netcracker.validators"})
public class Injector {

    /**
     * Принимает объект, если поле объекта имеет анотацию @AutoInjectable,
     * метод ищет классы в указанных пакетах,
     *  создает Instance
     * @param <T> - тип объекта
     * @param object - проверяем поля данного объекта
     * @return - сущность с внедренным свойством
     */
    public static <T> T inject(T object) throws Exception {
        String[] packageName = Injector.class.getAnnotation(Configuration.class).packages();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {

                if (field.getGenericType().getTypeName().startsWith("java.util.List<")) {

                    List<Class> classes = getClasses(packageName, field.getAnnotation(AutoInjectable.class).clazz());
                    field.setAccessible(true);
                    List<Object> objectList = new ArrayList<Object>();
                    for(Class currentClass : classes){
                        objectList.add(currentClass.newInstance());
                    }
                    field.set(object, objectList);
                } else {
                    List<Class> classes = getClasses(packageName, field.getType());
                    if (classes.size() > 1) {
                        throw new Exception("Найдено больше одного класса");
                    } else if (classes.size() == 0) {
                        throw new Exception("Ничего не найдено");
                    }
                    field.setAccessible(true);
                    field.set(object, classes.get(0).newInstance());
                }
            }
        }
        return object;
    }

    /**
     *Получить классы
     * @param packageName - имя пакета, в котором ищем классы
     * @param clazz
     * @return - классы
     */
    private static List<Class> getClasses(String[] packageName, Class clazz) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();//текущий загрузчик
        List classes = new ArrayList();

        for(String currentPackage : packageName){
            String path = currentPackage.replace('.', '/');//путь к пакету
            URL resource = classLoader.getResource(path);//ресурсы по заданному пути
            File directory = new File(resource.getFile());//файл ресурса пакета
            classes.addAll(findClasses(directory, currentPackage, clazz));
        }

        return classes;
    }

    /**Ищем в пакете packageName классы
     * @param directory - директория
     * @param packageName - имя пакета
     * @param clazz

     */
    private static List<Class> findClasses(File directory, String packageName, Class clazz) throws ClassNotFoundException {

        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();//файлы в пакете который мы передаем в метод(пакет)
        for (File file : files) {
            if (file.isDirectory()) {
                //если директория-ищем классы в директории,и добавляем их
                classes.addAll(findClasses(file, packageName + "." + file.getName(), clazz));
            } else if (file.getName().endsWith(".class")) {
                Class<?> foundClass = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                //является ли foundClass экземпляром clazz
                if (clazz.isAssignableFrom(foundClass)&&
                        !foundClass.isInterface()) {
                    classes.add(foundClass);
                }
            }
        }
        return classes;
    }
}
