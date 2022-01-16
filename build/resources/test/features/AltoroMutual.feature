Feature: Transferencia de fondos entre cuentas

  Rule: El  usuario podra realizar la transferencia de fondos entre cuentas de forma satisfactoria
  @Test
  Scenario Outline: Como usuario existente y habilitado, quiero realizar una transferencia de fondos a la tarjeta de credito
    Given navego al portal de transferencias
    And ingreso a la pagina de login
    And me autentico correctamente con usuario valido
    When ingreso a la opcion de transferencias
    And selecciono las cuentas y <monto> a transferir
    And presiono el boton de transferir
    Then se observa confirmacion de la transferencia exitosa

      Examples:
      |monto |
      |10    |
