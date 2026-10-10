import java.util.Scanner;

public class MushroomIdentifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Think of one of these mushrooms: \nAgaric Jaunissant, \nAmanite tue-mouches, \nCepe de bordeaux, \nCoprin chevelu, \nGirolle, \nPied bleu.");
        System.out.println("Answer with 'yes' or 'no'.\n");
        
        System.out.print("1. Does your mushroom have a convex cup?: ");
        String convex = scanner.nextLine();
        
        if (convex.equals("yes")) {
            System.out.print("2. Does your mushroom grow in a meadow?: ");
            String meadow = scanner.nextLine();
            
            if (meadow.equals("yes")) {
                System.out.println("Result: Your mushroom is Agaric jaunissant.");
            } else {
                System.out.print("3. Does your mushroom have a ring?: ");
                String ring = scanner.nextLine();
                
                if (ring.equals("yes")) {
                    System.out.println("Result: Your mushroom is Amanite tue-mouches.");
                } else {
                    System.out.println("Result: Your mushroom is Pied bleu.");
                }
            }
        } else {
            System.out.print("2. Does your mushroom have pores?: ");
            String pores = scanner.nextLine();
            
            if (pores.equals("yes")) {
                System.out.println("Result: Your mushroom is Cepe de bordeaux.");
            } else {
                System.out.print("3. Does your mushroom have a ring?: ");
                String ring = scanner.nextLine();
                
                if (ring.equals("yes")) {
                    System.out.println("Result: Your mushroom is Coprin chevelu.");
                } else {
                    System.out.println("Result: Your mushroom is Girolle.");
                }
            }
        }
        
        scanner.close();
    }
}