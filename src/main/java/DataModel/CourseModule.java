package DataModel;

public class CourseModule {
    public String englishName;
    public String arabicName;
    public String englishDesc;
    public String arabicDesc;
    public String hours;
    public String minutes;

    public CourseModule(String englishName, String arabicName, String englishDesc, String arabicDesc, String hours, String minutes) {
        this.englishName = englishName;
        this.arabicName = arabicName;
        this.englishDesc = englishDesc;
        this.arabicDesc = arabicDesc;
        this.hours = hours;
        this.minutes = minutes;
    }

    public CourseModule() {
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishDesc() {
        return englishDesc;
    }

    public void setEnglishDesc(String englishDesc) {
        this.englishDesc = englishDesc;
    }

    public String getArabicDesc() {
        return arabicDesc;
    }

    public void setArabicDesc(String arabicDesc) {
        this.arabicDesc = arabicDesc;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }
}
