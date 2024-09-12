package CollectionObjects;

import java.util.Scanner;

public class GetCoordinates {
    Scanner scanner;

    public GetCoordinates(Scanner scanner) {
        this.scanner = scanner;
    }

    public Coordinates build() {
        Coordinates coordinates = new Coordinates();

        try {
            System.out.print("Введите x: ");
            String line = this.scanner.nextLine();
            Double x = Double.valueOf(line);
            if (x == null) {
                throw new RuntimeException("Значение x не может быть null!");
            }
            coordinates.setX(x);


            System.out.print("Введите y: ");
            String line1 = this.scanner.nextLine();
            Float y = Float.valueOf(line1);
            if (y == null || y < -516) {
                throw new RuntimeException("Значение y не может быть меньше -516");
            }
            coordinates.setY(y);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return coordinates;
    }
}
