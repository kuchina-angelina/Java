package project;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


import static project.GenerateId.generateId;

public class Task {
    int id; //номер задачи
    String name,information,endDate,status, formattedDate; //наименование,описание,дата выполнения,статус,форматированная дата
    LocalDate createDate; //дата создания
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    Task(String endDate,String name, String information){
        this.id = generateId(Planner.ids); //здесь вызывается метод для того,чтобы сгенерировать номер
        this.createDate = LocalDate.now(); // дата выполнения по умолчанию стоит текущая
        this.name = name;
        this.information = information;
        this.status = "Не выполнено"; //статус по умолчанию "Не выполнено"
        this.endDate = endDate;


    }

    public int getId() {
        return id;
    }

    public LocalDate getCreateDate(){
        return createDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public String getName(){
        return name;
    }

    public String getInformation(){
        return information;
    }

    public String getStatus(){
        return status;
    }

    //метод, который используется для форматирования строки в привычный формат, чисто эстетика
    public String getFormattedDate(){
        return formattedDate = createDate.format(dateTimeFormatter);

    }

    //методы, которые используются для редактирования задания
    public void setInfo(String information){
        this.information = information;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setDate(String endDate){
        this.endDate = endDate;
    }


}
