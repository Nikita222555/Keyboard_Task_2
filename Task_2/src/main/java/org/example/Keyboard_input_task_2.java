/**
 *  Программа Keyboard_input_task_2 реализует
 *  алгоритм, вычисляющий количество денег каждого номинала,
 *  которые необходимо выдать клиенту в качестве сдачи
 *  Организован ввод данных с клавиатуры
 *
 * @атор Томилов Н.С.
 * @версия 1.0
 * @от 2024-01-23
 */

package org.example;
import java.util.*;

public class Keyboard_input_task_2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();     // Сюда положим ответ на задачу
        Scanner sc = new Scanner(System.in);                 // Ввод данных
        System.out.println("Введите цену заказа: ");
        int price = sc.nextInt();
        System.out.println("Введите размер платежа: ");
        int order = sc.nextInt();

        int rez = order - price;                                            // Считаем сдачу
        int[]coins = {5000, 2000, 1000, 500, 200, 100, 50, 10, 5, 2, 1};    // Наши номиналы
        int count = 0;                                                      // Для подсчета количества номиналов


        if(rez == 0){                                        //Проверка на равенство
            System.out.println("Без сдачи");
            return;
        }

        for (int i = 0; i<coins.length; i++){                // Поехали...
            while(rez-coins[i] >= 0){                        // Проверяем можно ли брать крупными и инкрементируем счетчик
                rez -= coins[i];                             // Отдаем крупные
                count++;
            }
            map.put(coins[i], count);                        // Крупные кончились, ложим в мапу, ключ - номинал
            count = 0;                                       // Следующий номинал
        }

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(map);  // Мапа - рандом, поэтому используем эту реализацию
        System.out.println("<<Номинал купюры>> = <<количество>>          ВАША СДАЧА:");
        System.out.println(sortedMap);
    }
}