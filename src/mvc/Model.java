package mvc;

/**
 * Модель данных
 */
public class Model {
    //Атрибуты класса..
    int DepNo;
    String Date;

    //Конструктор класса..
    //Методы класса..
    /**
     * @return номер подразделения
     */
    public int getDepNo() {
        return DepNo;
    }

    /**
     * @param depNo Номер подразделения
     */
    public void setDepNo(int depNo) {
        this.DepNo = depNo;
    }

    /**
     * @return дата
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param date дата в формате DDMMYY
     */
    public void setDate(String date) {
        this.Date = date;
    }
}
