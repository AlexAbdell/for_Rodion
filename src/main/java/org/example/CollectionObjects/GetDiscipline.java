package org.example.CollectionObjects;

import java.util.Scanner;

public class GetDiscipline {
    Scanner scanner;
    public GetDiscipline(Scanner scanner){
        this.scanner = scanner;
    }
    public Discipline build() {
        Discipline discipline = new Discipline();


        try {
            System.out.print("Введите название дисциплины: ");
            String name = this.scanner.nextLine();
            if (name == null || name.isEmpty()) {
                throw new RuntimeException("Название дисциплины не может быть null или пустой строкой!");
            }
            discipline.setName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.print("Введите колличество работ: ");
            String line = (this.scanner.nextLine());
            Long labsCount = Long.valueOf(line);
            if (labsCount< 1) {
                throw  new RuntimeException("Ошибка!!! Лекторские часы не могут быть меньше 1.");
            }
            discipline.setLabsCount(labsCount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return discipline;
    }
}
