class Cuenta(val numCuenta: Int, var saldo: Double) {

    companion object {
        fun esMorosa(persona: Persona): Boolean {
            for (cuenta in persona.cuentas) {
                if (cuenta != null && cuenta.saldo < 0) {
                    println("Todas las cuentas tienen saldo positivo, la persona no es morosa.")
                    return true
                } else {
                    println("Una cuenta es nula o su saldo es negativo, la persona es morosa.")
                    return false
                }
            }
            return false
        }

        fun realizarTransferencia(
            personaA: Persona,
            personaB: Persona,
            numCuenta1: Int,
            numCuenta2: Int,
            cantidad: Double
        ): Boolean {
            if (cantidad <= 0) {
                println("La cantidad a transferir no puede ser menor o igual que 0.")
                return false
            }

            val cuentaA = personaA.cuentas.find { it?.numCuenta == numCuenta1 }
            val cuentaB = personaB.cuentas.find { it?.numCuenta == numCuenta2 }

            if (cuentaA == null || cuentaB == null) {
                println("Una de las cuentas no existe.")
                return false
            }

            if (cantidad > cuentaA.saldo) {
                println("Saldo insuficiente en la cuenta de origen.")
                return false
            }

            cuentaA.saldo -= cantidad
            cuentaB.saldo += cantidad

            println("Transferencia hecha con éxito.")
            return true

        }
    }

    fun consultarSaldo(): String {
        return "Su saldo es de ${saldo}€"
    }

    fun recibirAbono(cantidad: Double): Boolean {
        if (cantidad <= 0) {
            println("El abono no puede ser negativo.")
            return false
        } else {
            saldo += cantidad
            println("El abono de $cantidad€ ha actualizado su saldo.")
            return true
        }
    }

    fun realizarPago(cantidad: Double): Boolean {
        if (cantidad <= 0) {
            println("La cantidad no puede ser negativa.")
            return false
        } else {
            saldo -= cantidad
            println("El pago de $cantidad€ ha actualizado su saldo.")
            return true
        }
    }
}