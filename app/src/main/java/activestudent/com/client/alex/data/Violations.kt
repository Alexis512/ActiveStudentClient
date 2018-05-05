package activestudent.com.client.alex.data

import activestudent.com.client.alex.model.ViolationsItems

/**
 * Created by alex on 18.02.2018.
 */
class Violations {

    fun getViolationsItem(): ArrayList<ViolationsItems> {

        //вынести array.xml
        val violations = ArrayList<ViolationsItems>()
        violations.add(ViolationsItems("Замена лампочки", "Электрик"))
        violations.add(ViolationsItems("Замена замка", "Слесарь"))
        violations.add(ViolationsItems("Снег у входа", "Дворник"))
        violations.add(ViolationsItems("Текст тест", "Дворник"))
        violations.add(ViolationsItems("Замена разетка", "Электрик"))
        violations.add(ViolationsItems("Ремонт стен", "Слесарь"))
        violations.add(ViolationsItems("Ремонт комнаты", "Слесарь"))
        violations.add(ViolationsItems("Ремент пола", "Слесарь"))
        violations.add(ViolationsItems("Мусор у входа", "Дворник"))
        violations.add(ViolationsItems("Проблемы с лифтом", "Электрик"))
        violations.add(ViolationsItems("Снег у входа", "Дворник"))
        violations.add(ViolationsItems("Текст тест", "test"))
        violations.add(ViolationsItems("Текст тест1", "test"))
        violations.add(ViolationsItems("Текст тест2", "test"))
        violations.add(ViolationsItems("Текст тест3", "test"))
        violations.add(ViolationsItems("Текст тест4", "test"))
        violations.add(ViolationsItems("Текст тест5", "test"))
        violations.add(ViolationsItems("Текст тест6", "test"))
        violations.add(ViolationsItems("Текст тест7", "test"))
        violations.add(ViolationsItems("Другое", "test"))
        return violations
    }
}