fun main(){
    val persona1 = Persona("77497602E")
    val cuenta1 = Cuenta(31, 0.0)
    val cuenta2 = Cuenta(44, 700.0)

    persona1.anadirCuenta(cuenta1)
    persona1.anadirCuenta(cuenta2)

    cuenta1.recibirAbono(1100.0)
    cuenta2.realizarPago(750.0)

    Cuenta.esMorosa(persona1)

    Cuenta.realizarTransferencia(persona1, persona1, 31, 44, 200.0)
    println(cuenta1.consultarSaldo())
    println(cuenta2.consultarSaldo())
}