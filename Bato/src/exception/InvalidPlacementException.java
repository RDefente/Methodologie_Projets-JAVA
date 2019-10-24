package exception;

public class InvalidPlacementException extends Exception {
    private String message;

    public InvalidPlacementException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
