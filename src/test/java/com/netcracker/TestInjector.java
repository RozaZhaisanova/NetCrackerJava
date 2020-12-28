package com.netcracker;


import com.netcracker.di.Injector;
import com.netcracker.repository.Csv;
import com.netcracker.repository.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;

public class TestInjector {

    @Test
    public void injectSort() throws IOException, ClassNotFoundException {
        try{
            Repository repository = new Repository();
            Injector.inject(repository);
            Field[] fields = Repository.class.getDeclaredFields();
            for(Field field : fields){
                if(field.getName().equals("sort")){
                    field.setAccessible(true);
                    Assert.assertNotNull(field.get(repository));
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void injectValid()  {
        try{
            Csv csv = new Csv();
            Injector.inject(csv);
            Field[] fields = Csv.class.getDeclaredFields();
            for(Field field : fields){
                if(field.getName().equals("validators")){
                    field.setAccessible(true);
                    Assert.assertNotNull(field.get(csv));

                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
