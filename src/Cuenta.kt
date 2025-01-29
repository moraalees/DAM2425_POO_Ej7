class Cuenta(val numCuenta: Int, var saldo: Double){

    fun consultarSaldo(): String{
        return "Su saldo es de ${saldo}€"
    }

    fun recibirAbono(cantidad: Double): Boolean{
        if (cantidad <= 0){
            println("El abono no puede ser negativo.")
            return false
        } else {
            saldo += cantidad
            println("El abono de $cantidad€ ha actualizado su saldo.")
            return true
        }
    }

    fun realizarPago(cantidad: Double): Boolean{
        if (cantidad <= 0 && cantidad > saldo){
            println("La cantidad está en un formato inválido.")
            return false
        } else {
            saldo -= cantidad
            println("El pago de $cantidad€ ha actualizado su saldo.")
            return true
        }
    }

    fun personaMorosa(persona: Persona): Boolean{
        for (cuenta in persona.cuentas){
            if (cuenta != null && cuenta.saldo < 0){
                println("Todas las cuentas tienen saldo positivo, no es morosa.")
                return true
            } else {
                println("Una cuenta es nula o su saldo es negativo, es morosa.")
            }
        }
        return false
    }

}