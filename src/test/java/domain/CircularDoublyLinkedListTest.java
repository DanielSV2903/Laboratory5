package domain;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class CircularDoublyLinkedListTest {
    @Test
    void test1() {
        CircularLinkedList list = new CircularLinkedList();
        CircularDoublyLinkedList a,b,c,d;
        a=new CircularDoublyLinkedList();
        b= new  CircularDoublyLinkedList();
        c=new CircularDoublyLinkedList();
        d=new CircularDoublyLinkedList();

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
        Calendar calendar = Calendar.getInstance();
        //Datos quemados para asegurar
        list.add(new Employee(1, "González", "Carlos", "Informática", createDate(2003).getTime())); //20 años
        list.add(new Employee(2, "Rodríguez", "María", "Administración", createDate(2000).getTime())); //23 años
        list.add(new Employee(3, "Pérez", "Juan", "Inglés", createDate(1998).getTime())); //25 años
        list.add(new Employee(4, "Fernández", "Lucía", "Turismo", createDate(1995).getTime())); //28 años
        list.add(new Employee(5, "López", "Andrés", "Agronomía", createDate(1993).getTime())); //30 años
        list.add(new Employee(6, "Martínez", "Sofía", "Diseño Publicitario", createDate(1989).getTime())); //34 años
        list.add(new Employee(7, "Sánchez", "Luis", "Diseño Web", createDate(1987).getTime())); //37 años
        list.add(new Employee(8, "Ramírez", "Valentina", "Asesor", createDate(1985).getTime())); //39 años
        list.add(new Employee(9, "Torres", "Diego", "Doctor", createDate(1981).getTime())); //42 años
        list.add(new Employee(10, "Romero", "Camila", "Abogado", createDate(1979).getTime())); //44 años
        list.add(new Employee(11, "Alvarez", "Javier", "Ingeniero", createDate(1975).getTime())); //48 años
        list.add(new Employee(12, "García", "Clara", "Psicólogo", createDate(1971).getTime())); //52 años
        list.add(new Employee(13, "Hernández", "Miguel", "Cocinero", createDate(1968).getTime())); //55 años
        list.add(new Employee(14, "Luna", "Ana", "Arquitecto", createDate(1966).getTime())); //57 años
        list.add(new Employee(15, "Vega", "Raúl", "Abogado", createDate(1961).getTime())); //60 años
        list.add(new Employee(16, "Morales", "Elena", "Fisioterapeuta", createDate(1962).getTime())); //63 años
        list.add(new Employee(17, "Ortiz", "Pedro", "Veterinario", createDate(1960).getTime())); //65 años

        //Datos dinamicos (Aleatorios)
        for (int i = 0; i < profesiones.length; i++) {
            calendar.set(util.Utility.random(1967, 2005), util.Utility.random(12), util.Utility.random(28));
            int random = util.Utility.random(8);
            list.add(new Employee(i + 1, apellidos[i], nombres[i], profesiones[random], calendar.getTime()));
        }
        System.out.println(list);
        try {
            ageList(list,a,18,25);
            ageList(list,b,26,40);
            ageList(list,c,41,55);
            ageList(list,d,56,100);
            if (a!=null&&b!=null&&c!=null&&d!=null) {
                System.out.println("Los empleados con edad entre 18 y 25 son:\n" +a);
                System.out.println("Los empleados con edad entre 26 y 40 son:\n" + b);
                System.out.println("Los empleados con edad entre 41 y 55 son:\n" + c);
                System.out.println("Los empleados con edad mayor a 55:\n" + d);
            }
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }
    private CircularDoublyLinkedList ageList(CircularLinkedList list,CircularDoublyLinkedList llenar,int b1,int b2) throws ListException {
        for (int i=1;i<list.size();i++){
            Employee employee= (Employee) list.getNode(i).data;
            int edad = employee.getAge();
            if (edad >= b1 && edad <= b2)
                llenar.add(employee);
        }
        return llenar;
    }
    private Calendar createDate(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);  // Enero
        calendar.set(Calendar.DAY_OF_MONTH, 1);  // Día 1
        return calendar;
    }
}