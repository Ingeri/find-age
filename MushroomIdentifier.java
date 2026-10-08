import java.util.Scanner;

public class MushroomIdentifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Think of one of these mushrooms: Agaric Jaunissant, Amanite tue-mouches, Cepe de bordeaux, Coprin chevelu, Girolle, Pied bleu.");
        System.out.println("Answer with 'yes' or 'no'.\n");
        
        // Question 1
        System.out.print("1. Does your mushroom have a convex cup?");
        String convex = scanner.nextLine().trim().toLowerCase();
        
        if (convex.equals("yes")) {
            // Group: Agaric jaunissant, Amanite tue-mouches, Pied bleu
            // Question 2
            System.out.print("2. Does your mushroom grow in a meadow?");
            String meadow = scanner.nextLine().trim().toLowerCase();
            
            if (meadow.equals("yes")) {
                System.out.println("Result: Your mushroom is Agaric jaunissant.");
            } else {
                // Forest + Convex cup: Amanite tue-mouches or Pied bleu
                // Question 3
                System.out.print("3. Does your mushroom have a ring?");
                String ring = scanner.nextLine().trim().toLowerCase();
                
                if (ring.equals("yes")) {
                    System.out.println("Result: Your mushroom is Amanite tue-mouches.");
                } else {
                    System.out.println("Result: Your mushroom is Pied bleu.");
                }
            }
        } else {
            // Group: Cepe de bordeaux, Coprin chevelu, Girolle
            // Question 2
            System.out.print("2. Does your mushroom have pores?");
            String pores = scanner.nextLine().trim().toLowerCase();
            
            if (pores.equals("yes")) {
                System.out.println("Result: Your mushroom is Cepe de bordeaux.");
            } else {
                // Coprin chevelu or Girolle
                // Question 3
                System.out.print("3. Does your mushroom have a ring?");
                String ring = scanner.nextLine().trim().toLowerCase();
                
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