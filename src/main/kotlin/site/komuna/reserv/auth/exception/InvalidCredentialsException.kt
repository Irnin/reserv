package site.komuna.reserv.auth.exception

class InvalidCredentialsException: RuntimeException(){
    override val message: String
        get() = "Invalid credentials"
}