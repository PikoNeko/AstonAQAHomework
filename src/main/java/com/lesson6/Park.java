package com.lesson6;

public class Park {

    //Поля класса Парк
    private String name;
    private String description;
    private String location;
    private String workingHours;
    private String contactInfo;

    //GET и SET для полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


    public class AttractionInfo {

        //Поля внутреннего класса Информация об аттракционах
        private String attractionName;
        private String attractionDescription;
        private int attractionCost;
        private String attractionWorkingHours;

        //Конструктор класса
        AttractionInfo() {
            this.attractionName = "Карусель";
            this.attractionDescription = "Невероятная карусель, крутящаяся со скоростью света";
            this.attractionCost = 5;
            this.attractionWorkingHours = "00:00 - 23.59";
        }

        //GET и SET для полей
        public String getAttractionName() {
            return attractionName;
        }

        public void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }


        public String getAttractionDescription() {
            return attractionDescription;
        }

        public void setAttractionDescription(String attractionDescription) {
            this.attractionDescription = attractionDescription;
        }


        public int getAttractionCost() {
            return attractionCost;
        }

        public void setAttractionCost(int attractionCost) {
            this.attractionCost = attractionCost;
        }


        public String getAttractionWorkingHours() {
            return attractionWorkingHours;
        }

        public void setAttractionWorkingHours(String attractionWorkingHours) {
            this.attractionWorkingHours = attractionWorkingHours;
        }

        //метод вывода информации об аттракционе

        public void print() {
            System.out.println("Аттракцион - " + attractionName + "\n" + attractionDescription + "\n" +
                    "Время работы: " + attractionWorkingHours + "\n" + "Стоимость: " + attractionCost + "р." + "\n");
        }

    }
}
