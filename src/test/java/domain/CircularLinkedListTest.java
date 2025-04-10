package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {
    @Test
    void test1(){
        CircularLinkedList list = new CircularLinkedList();

        String[] profesiones = {
                "Informática", "Administración", "Inglés", "Turismo", "Agronomía",
                "Diseño Publicitario", "Diseño Web", "Asesor", "Doctor", "Abogado"
        };
        String[] nombres = {
                "Carlos", "María", "Juan", "Lucía", "Andrés",
                "Sofía", "Luis", "Valentina", "Diego", "Camila"
        };

        String[] apellidos = {
                "González", "Rodríguez", "Pérez", "Fernández", "López",
                "Martínez", "Sánchez", "Ramírez", "Torres", "Romero"
        };
        Calendar calendar=Calendar.getInstance();

        for (int i=0;i<profesiones.length;i++){
            calendar.set(util.Utility.random(1967,2005),util.Utility.random(12),util.Utility.random(28));
            int random=util.Utility.random(8);
            list.add(new Employee(i+1,apellidos[i],nombres[i],profesiones[random],calendar.getTime()));
        }
        try {
            System.out.println(showAgeList(list,"Empleados con rango de edad entre 18 y 25",18,25));
            System.out.println(showAgeList(list,"Empleados con rango de edad entre 26 y 40",26,40));
            System.out.println(showAgeList(list,"Empleados con rango de edad entre 41 y 55",41,55));
            System.out.println(showAgeList(list,"Empleados con rango de edad mayor que 55",56,100));
            String result="";
            String searched="Doctor";
            CircularLinkedList titles=getTitleList(list,searched);
            if (!titles.isEmpty()&&titles!=null){
            for (int i=1;i<titles.size();i++){
                Employee employee= (Employee) titles.getNode(i).data;
                result+=employee+"\n";
            }
            }

            System.out.println(result!=""?"Empleados que trabajan como"+ searched+"\n"+result:"No hay empleados que trabajen como "+searched);
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }
    private String showAgeList(CircularLinkedList list,String msg,int b1,int b2) throws ListException {
        String result="";
        for (int i=1;i<list.size();i++){
            Employee employee= (Employee) list.getNode(i).data;
            int edad = employee.getAge();
            if (edad >= b1 && edad <= b2)
                result+=employee+"\n";
        }
        return msg+"\n"+result;
    }
    private CircularLinkedList getTitleList(CircularLinkedList list,String title) throws ListException {
        CircularLinkedList matchList=new CircularLinkedList();
        for (int i=1;i<list.size();i++){
            Employee employee=(Employee) list.getNode(i).data;
            if(util.Utility.compare(employee.getTitle().toLowerCase().trim(),title.trim().toLowerCase())==0)
                matchList.add(employee);
        }
        return matchList;
    }
}