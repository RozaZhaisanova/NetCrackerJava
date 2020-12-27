package com.netcracker;


import com.netcracker.di.Injector;
import com.netcracker.repository.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;

public class TestInjector {

    @Test
    public void inject() throws IOException, ClassNotFoundException {
        try{
            Repository repository = new Repository();
            Injector.inject(repository);
            Field[] fields = Repository.class.getDeclaredFields();
            for(Field field : fields){
                if(field.getName().equals("sort")){
                    field.setAccessible(true);
                    Assert.assertTrue(field.get(repository)!=null);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
