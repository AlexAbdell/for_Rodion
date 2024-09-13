package CollectionObjects;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class GetLabWork {
    Scanner scanner;

    public GetLabWork(Scanner scanner) {
        this.scanner = scanner;
    }

    public LabWork build(Long id) {
        LabWork labWork = this.build();
        labWork.setId(id);
        return labWork;
    }

    public LabWork build() {
        LabWork labWork = new LabWork();

        try {
            System.out.print("Введите название лабораторной работы: ");
            String name = this.scanner.nextLine();
            if (name == null || name.isEmpty()) {
                throw new RuntimeException("Название дисциплины не может быть null или пустой строкой!");
            }
            labWork.setName(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        try {
            System.out.print("Введите баллы лабораторной работы: ");
            String line = this.scanner.nextLine();
            float minimalpoint = Float.parseFloat(line);
            if (minimalpoint <= 0) {
                throw new RuntimeException("Балл должен быть больше 0!");
            }
            labWork.setMinimalPoint(minimalpoint);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        try {
            System.out.println("Введите координаты: ");
            GetCoordinates getCoordinates = new GetCoordinates(this.scanner);
            labWork.setCoordinates(getCoordinates.build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        try {
            System.out.print("Введите наcтройку работы: ");
            String line1 = this.scanner.nextLine();
            long tunedInWorks = Long.parseLong(line1);
            labWork.setTunedInWorks(tunedInWorks);
        } catch (NumberFormatException e){
            throw new RuntimeException("Введен неверный формат данных");
        }

        try {
            System.out.printf("Введите сложность лабораторной работы (%S): %n", Difficulty.concat(", "));
            String line2 = this.scanner.nextLine().toUpperCase();
            Difficulty difficulty = Difficulty.valueOf(line2);
            labWork.setDifficulty(difficulty);

        } catch (Exception e) {
            System.out.println("Неверный ввод!");
            System.out.println(e.getMessage());
            return null;
        }

        try {
            GetDiscipline getDiscipline = new GetDiscipline(this.scanner);
            labWork.setDiscipline(getDiscipline.build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return labWork;
    }
}
