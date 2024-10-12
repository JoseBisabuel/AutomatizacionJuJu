Feature: Modulo Alerts, Frame and Windows

  Background:
    Given Cargar Pagina Web DemoQa
    Then Cargar la informacion del DOM ModuleAlerts,Frame&Windows.json
    And Validar si el elemento PantallaInicio se visualiza
    And Tomar Captura de pantalla: PaginaInicio
    And Adjunto una Captura de pantalla al informe PaginaInicio
    And espereme 2 segundos
    And Busque el elemento ModuleAlerts,Frame&Windows
    And Hacer Click en El elemento ModuleAlerts,Frame&Windows
    And espereme 2 segundos

  @ModuloAlerts,FrameAndWindows
  Scenario: Modulo Alerts, Frame and Windows
    And Busque el elemento ModalDialog
    And Hacer Click en El elemento ModalDialog
    And espereme 2 segundos
    And Busque el elemento SmallModal
    And Hacer Click en El elemento SmallModal
    And Validar si el elemento OpenSmallModal contiene el texto This is a small modal. It has very less content
    And Tomar Captura de pantalla: SmallModal
    And Adjunto una Captura de pantalla al informe SmallModal
    And espereme 2 segundos
    And Hacer Click en El elemento CerrarSmallModal
    And Hacer Click en El elemento LargeModal
    And Validar si el elemento TexLargeModal se visualiza
    And Tomar Captura de pantalla: LargeModal
    And Adjunto una Captura de pantalla al informe LargeModal
    And espereme 2 segundos
    And Hacer Click en El elemento CerrarLargeModal