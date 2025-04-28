package enums.example3;

public enum EmpleadoTipo {
    ADMINISTRADOR, TECNICO, DIRECTIVO, ORDENANZA;

    public double getSalario() {
        switch (this) {
            case ADMINISTRADOR:
                return 100000;
            case TECNICO:
                return 80000;
            case DIRECTIVO:
                return 120000;
            case ORDENANZA:
                return 150000;
            default:
        }

        return 0;
    }
}
