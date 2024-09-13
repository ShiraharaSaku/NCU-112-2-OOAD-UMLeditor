package Mode;

public enum ModeType {
    SELECT("Select"),
    ASSOCIATION("Association"),
    GENERALIZATION("Generalization"),
    COMPOSITION("Composition"),
    CLASS("Class"),
    USECASE("UseCase"),
    NULL("");
	
	String pictureName;
	
	private ModeType(String pictureName) {
        this.pictureName = pictureName;
    }
	
    public String pictureName() {
        return pictureName;
    }
    
}

