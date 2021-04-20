package MP1;

public enum Subject {
    MAD("Matematyka Dyskretna"), MAS("Modelowanie i Analiza Systemów informacyjnych"),
    PPJ("Podstawy Programowania w Javie");
    private final String fullName;

    public String getFullName() {
        return fullName;
    }

    Subject(String fullName) {
        this.fullName = fullName;
    }
}
