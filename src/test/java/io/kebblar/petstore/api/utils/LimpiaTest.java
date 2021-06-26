package io.kebblar.petstore.api.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.service.AnuncioServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LimpiaTest {

    @Test
    public void pba() {
        prueba("hola",                             
                "hola");
        
        prueba("ñ",                             
                "n");

        prueba("       gús ta  v&o   lanñd o", 
               "gus-ta-v-o-lannd-o");
        
        prueba("",                             
               "");
        
        prueba("           ",                  
               "");
        
        prueba("      ñ    ñ    ",             
               "n-n");
        
        prueba("       &",                     
               "-");
        
        prueba("      $   $    ",              
               "-");
        
        prueba("       áéíóúñ   ",             
               "aeioun");
        
        prueba("      ÁÉÍÓÚÑ     ",            
               "aeioun");
        
        prueba("      ÁÉÍ ÓÚÑ     ",           
               "aei-oun");
    }

    private void prueba(String cadena, String esperada) {
        String result = AnuncioServiceImpl.limpia(cadena);
        boolean test = esperada.equals(result);
        if(!test) {
            System.out.println(cadena);
            System.out.println(result);
        }
        assert(test);
    }
}
