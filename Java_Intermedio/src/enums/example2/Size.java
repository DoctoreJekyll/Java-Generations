package enums.example2;

public enum Size {
    SMALL, MEDIUM, LARGE, X_LARGE;

    public String getSize()
    {
        switch (this){
            case SMALL : return "Prenda pequeña";
            case MEDIUM : return "Prenda mediana";
            case LARGE : return "Prenda grande";
            case X_LARGE: return "Prenda extra grande";
            default: return "No definido";
        }
    }
}
