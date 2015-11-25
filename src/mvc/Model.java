package mvc;

/**
 * Модель данных
 */
public class Model {
    //Атрибуты класса..
    int DepNo; /** Номер подразделения **/
    int Date;  /** Дата в формате DDMMYY **/

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
    public int getDate() {
        return Date;
    }

    /**
     * @param date дата в формате DDMMYY
     */
    public void setDate(int date) {
        this.Date = date;
    }
}
