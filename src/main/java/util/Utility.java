package util;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utility {
    private static  Random random;
    private static CircularLinkedList employeeList;




    //constructor estatico, inicializador estatico
    static {
        // semilla para el random
        long seed = System.currentTimeMillis();
        random = new Random(seed);
        employeeList = new CircularLinkedList();
    }

    public static CircularLinkedList getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(CircularLinkedList employeeList) {
        Utility.employeeList = employeeList;
    }

    public static int random(int bound){
        //return (int)Math.floor(Math.random()*bound); //forma 1
        return 1+random.nextInt(bound);
    }
    public static int random(int bound1,int bound2){
        //return (int)Math.floor(Math.random()*bound); //forma 1
        return 1+random.nextInt(bound1,bound2);
    }

    public static void fill(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = random(99);
        }
    }

    public static String format(long n) {
        return new DecimalFormat("###,###,###.##").format(n);
    }

    public static int min(int x, int y) {
        return x<y ? x : y;
    }

    public static int max(int x, int y) {
        return x>y ? x : y;
    }

    public static String show(int[] a) {
        String result="";
        for(int item : a){
            if(item == 0) break; //si es cero es xq no hay mas elementos
            result+=item + " ";
        }
        return result;
    }

    public static int compare(Object a, Object b) {
        switch(instanceOf(a, b)){
            case "Integer":
                Integer int1 = (Integer)a; Integer int2 = (Integer)b;
                return int1 < int2 ? -1 : int1 > int2 ? 1 : 0;

            case "String":
                String str1 = (String)a; String str2 = (String)b;
                return str1.compareTo(str2) < 0 ? -1 : str1.compareTo(str2) > 0 ? 1 : 0;

            case "Character":
                Character ch1 = (Character) a; Character ch2 = (Character) b;
                return ch1.compareTo(ch2) < 0 ? -1 : ch1.compareTo(ch2) > 0 ? 1 : 0;

            case "Employee":
                Employee st1 = (Employee) a; Employee st2 = (Employee) b;
                return st1.getId()<st2.getId() ? -1 :  st1.getId()>st2.getId()  ? 1 : 0;
        }
        return 2; //Unknown
    }

    public static String instanceOf(Object a, Object b){
        if(a instanceof Integer && b instanceof Integer) return "Integer";
        if(a instanceof String && b instanceof String) return "String";
        if(a instanceof Character && b instanceof Character) return "Character";
        if(a instanceof Employee && b instanceof Employee) return "Student";
        return "Unknown";
    }

    public static boolean validarEntradasStudent(TextField nombreField, TextField edadField, TextField idField) {

        //Validar nombre: solo letras y espacios
        String nombre = nombreField.getText().trim();
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            mostrarAlerta("El nombre solo debe contener letras y espacios.");
            return false;
        }
        String idTexto = idField.getText().trim();
        if (!idTexto.matches("[a-zA-Z0-9]{6}")) {
            mostrarAlerta("El formato del ID es incorrecto. Debe ser de 6 caracteres (letras y/o números).");
            idField.requestFocus();
            return false;
        }
        //Validar edad: entero entre 0 y 120
        try {
            int edad = Integer.parseInt(edadField.getText().trim());
            if (edad < 0 || edad > 120) {
                mostrarAlerta("La edad ingresada no es válida. (Rango: 0-110).");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("La edad debe ser un número entero.");
            return false;
        }
        //si todo está bien
        return true;
    }
    public static boolean validarEntradasCourse(String id,String name, int credits) {

        //Validar nombre: solo letras y espacios
        String nombre = name.trim();
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            mostrarAlerta("El nombre solo debe contener letras y espacios.");
            return false;
        }
        String idTexto = id.trim();
        if (!idTexto.matches("[A-Za-z]{2}-\\d{4}")) {
            mostrarAlerta("El formato del ID es incorrecto. Debe ser de 6 caracteres (letras y/o números).");
            return false;
        }
        //Validar edad: entero entre 0 y 8
        try {
            if (credits < 0 || credits > 8) {
                mostrarAlerta("Los creditos ingresados no son válidos. (Rango: 0-8).");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Ingrese los datos correctamente");
            return false;
        }
        //Si la validacion pasa, devuelve true
        return true;
    }

    private static void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de validación");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public static String dateFormat(Date birthDay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(birthDay);
    }
    public static int getAge(Date birthDay) {
        LocalDate birth=birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now=LocalDate.now();
        return Period.between(birth,now).getYears();
    }
}
