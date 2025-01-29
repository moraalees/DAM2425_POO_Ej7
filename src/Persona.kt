class Persona(private var dni: String) {
    val cuentas: Array<Cuenta?> = Array(3) { null }

    fun anadirCuenta(cuenta: Cuenta){
        for (i in cuentas.indices) {
            if (cuentas[i] == null) {
                cuentas[i] = cuenta
                println("¡Cuenta ${cuenta.numCuenta} añadida con éxito!")
                return
            }
        }
        println("No se pueden añadir más cuentas, ya hay 3 asignadas.")
    }


}