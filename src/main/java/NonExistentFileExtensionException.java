public class NonExistentFileExtensionException extends RuntimeException{
    public NonExistentFileExtensionException(String errMsg, Throwable err){
        super(errMsg, err);
    }


}
