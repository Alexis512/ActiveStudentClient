package activestudent.com.client.alex.data

import activestudent.com.client.alex.model.ViolationsItems

/**
 * Created by alex on 18.02.2018.
 */
class Violations {

    fun getViolationsItem() : ArrayList<ViolationsItems>{

        //вынести array.xml
        val violations = ArrayList<ViolationsItems>()
        violations.add(ViolationsItems("Замена лампочки", "Электрик"))
        violations.add(ViolationsItems("Замена замка", "Слесарь"))
        violations.add(ViolationsItems("Снег у входа", "Дворник"))
        violations.add(ViolationsItems("Текст тест", "тест"))
        violations.add(ViolationsItems("Замена разетка", "Электрик"))
        violations.add(ViolationsItems("Ремонт стен", "Рабочие"))
        violations.add(ViolationsItems("Ремонт комнаты", "Рабочие"))
        violations.add(ViolationsItems("Ремент пола", "Рабочие"))
        violations.add(ViolationsItems("Мусор у входа", "Дворник"))
        violations.add(ViolationsItems("Проблемы с лифтом", "Лифтер"))
        violations.add(ViolationsItems("Снег у входа", "Дворник"))
        violations.add(ViolationsItems("Текст тест", "Тест1"))
        violations.add(ViolationsItems("Текст тест1", "Тест2"))
        violations.add(ViolationsItems("Текст тест2", "Тест3"))
        violations.add(ViolationsItems("Текст тест3", "Тест4"))
        violations.add(ViolationsItems("Текст тест4", "Тест5"))
        violations.add(ViolationsItems("Текст тест5", "Тест6"))
        violations.add(ViolationsItems("Текст тест6", "Тест7"))
        violations.add(ViolationsItems("Текст тест7", "Тест8"))
        violations.add(ViolationsItems("Другое", "Тест9"))
        return violations
    }
}