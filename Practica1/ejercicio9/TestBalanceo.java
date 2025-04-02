package tp1.ejercicio9;

import java.util.Stack;

public class TestBalanceo {

    public static void main(String[] args) {
        String prueba1 = "{( ) [ ( ) ] }";
        String prueba2 = "( [ ) ]";
        
        System.out.println("Prueba 1: " + estaBalanceado(prueba1)); // true
        System.out.println("Prueba 2: " + estaBalanceado(prueba2)); // false
    }
    
    public static boolean estaBalanceado(String s) {
        Stack<Character> pila = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false; // No hay apertura 
                }
                char top = pila.pop();
                if (!coincide(top, c)) {
                    return false; // No coincide el cierre con la apertura
                }
            }
        }
        
        return pila.isEmpty();
    }
    
    private static boolean coincide(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
}
