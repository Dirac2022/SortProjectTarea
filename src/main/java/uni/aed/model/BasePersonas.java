/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.model;

import java.util.Random;

/**
 *
 * @author mitch
 */
public class BasePersonas {
    
   final String [] namesM = {"David",  "Miguel", "Guillermo", "Roberto"};
   final String [] namesF = {"Emilia", "Alicia", "Sofia", "Maria", "Olivia", "Isabel"};
   final char [] genders = {'M', 'F'};
   
   
   public Persona [] generaPersonas(int amount){
   
       Random random = new Random();
       Persona [] personas = new Persona [amount];
       Persona p;
       for(int i = 0; i < amount; i ++){
           
           p = new Persona();
           int genderIndex = random.nextInt(2);
           int age = random.nextInt(85) + 14;
           int namesIndex;
           if(genderIndex == 0){
              namesIndex = random.nextInt(namesM.length);
              p.setName(namesM[namesIndex]);
           }  
           else{
              namesIndex = random.nextInt(namesF.length);
              p.setName(namesF[namesIndex]);
           }
           p.setAge(age);
           p.setGender(genders[genderIndex]);  
           
           personas[i] = p;
       }
       
       return personas;
   }
   
}


