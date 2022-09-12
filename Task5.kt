/*
Дана следующая структура классов.
Компания: data class Company(val name: String, val departments: List<Department>)
Отдел: data class Department(val name: String, val employees: List<Employee>)
Сотрудник: data class Employee(val name: String, val age: Int)
Эти классы уже описаны в отдельных файлах в этом разделе и доступны здесь.

Написать функции для подсчета общего количества человек, работающих в заданной компании и их среднего возраста:
fun totalNumberOfEmployees(company: Company): Int
fun averageAgeOfEmployees(company: Company): Int

Для этой задачи есть видео с разбором.
*/

fun main() {
    val employee1 = Employee("Kirill",26)  // все сотрудники и их возраст
    val employee2 = Employee("Olga",23)
    val employee3 = Employee("Vasya",24)
    val employee4 = Employee("Oleg",24)
    val employee5 = Employee("Sveta",34)
    val employee6 = Employee("Nikita",19)
 //   val employee7 = Employee("Lena",56)

    val department1 = Department("IT", listOf(employee1,employee2,employee3))  // все депортаменты и "коллекция" их сотрудников
    val department2 = Department("HR", listOf(employee4))
    val department3 = Department("Finance", listOf(employee5,employee6,)) // сюда добавляем 7го сотрудника
    val company = Company("No name", listOf(department1,department2,department3))

    println(totalNumberOfEmployees(company))  // общее число сотрудников


    println(averageAgeOfEmployees(company)) // средний возраст сотрудников
}

fun averageAgeOfEmployees(company: Company): Int{
    var counter = 0
    var sumOfAge = 0 //сумма всех возрастов

    for(department in company.departments) // перебираем все отделы компании
       for(employee in department.employees) { // перебераем всех сотрудников каждого депортамента
           counter++
           sumOfAge += employee.age  // сумма всех возрастов
        }

   return sumOfAge/counter // вычесляем средний возраст
 }

fun totalNumberOfEmployees(company:Company): Int { //
    var counter = 0 // счетчик

    for(department in company.departments) // перебераем все отделы(депортаменты) Запускаем цикл
        counter += department.employees.size // считаем количество сотрудников в отделе и добавляем в счетчик(var counter)

    return counter  //

}
// Добавляем дата классы data class Company(val name: String, val departments: List<Department>)
                        //data class Department(val name: String, val employees: List<Employee>)
                       //data class Employee(val name: String, val age: Int)