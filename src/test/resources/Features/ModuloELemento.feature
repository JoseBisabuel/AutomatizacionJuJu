Feature: Modulo Elementos

  Background:
    Given Cargar Pagina Web DemoQa
    Then Cargar la informacion del DOM ElementModule.json
    And Validar si el elemento PantallaInicio se visualiza
    And Tomar Captura de pantalla: PaginaInicio
    And Adjunto una Captura de pantalla al informe PaginaInicio
    And espereme 2 segundos
    And Busque el elemento ModuloElementos
    And Hacer Click en El elemento ModuloElementos
    And espereme 2 segundos

  @TextBox
  Scenario: Formulario Text Box
    And Validar si el elemento SubmoduloTextBox se visualiza
    And Hacer Click en El elemento SubmoduloTextBox
    And lleneme el campo FullName con el texto Jose Orlando Bisabuel Caldon
    And lleneme el campo Email con el texto jose_bisabuel@hotmail.com
    And lleneme el campo CurrentAddress con el texto Carrera 12 # 43b 10
    And lleneme el campo PermanentAddress con el texto Neiva, Huila
    And Busque el elemento Submit
    And Hacer Click en El elemento Submit
    And Tomar Captura de pantalla: FormularioLleno
    And Adjunto una Captura de pantalla al informe FormularioLleno
    And Validar si el elemento FullNameGuardado se visualiza
    And Validar si el elemento EmailGuardado se visualiza
    And Validar si el elemento CurrentAddressGuardado se visualiza
    And Validar si el elemento PermanentAddressGuardado se visualiza

  @CheckBox
  Scenario: Check Box
    And Validar si el elemento SubmoduloCheckBox se visualiza
    And Hacer Click en El elemento SubmoduloCheckBox
    And espereme 2 segundos
    And Busque el elemento DesplegarLista
    And Hacer Click en El elemento DesplegarLista
    And espereme 2 segundos
    And Tomar Captura de pantalla: CasillasDisponibles
    And Marco la casilla Notes
    And Busque el elemento WorkSpace
    And Marco la casilla WorkSpace
    And Marco la casilla Office
    And Marco la casilla WordFile.doc
    And espereme 2 segundos
    And Tomar Captura de pantalla: CasillasMarcadas
    And Validar si el elemento SelectNotes se visualiza
    And Validar si el elemento SelecWorkSpaces se visualiza
    And Validar si el elemento SelecWorkSpaces(React) se visualiza
    And Validar si el elemento SelecWorkSpaces(Angular) se visualiza
    And Validar si el elemento SelecWorkSpaces(Veu) se visualiza
    And Validar si el elemento SelecOffice se visualiza
    And Validar si el elemento Office(Public) se visualiza
    And Validar si el elemento Office(Private) se visualiza
    And Validar si el elemento Office(Classified) se visualiza
    And Validar si el elemento Office(General) se visualiza
    And Validar si el elemento SelecWordFile.doc se visualiza
    And Tomar Captura de pantalla: ValidacionSeleccion

  @RadioButton
  Scenario: Radio Button
    And Validar si el elemento SubmoduloRadioButton se visualiza
    And Hacer Click en El elemento SubmoduloRadioButton
    And espereme 2 segundos
    And Busque el elemento Yes
    And Marco la casilla Yes
    And Validar si el elemento SelecYes se visualiza
    And Tomar Captura de pantalla: CasillaYes
    And espereme 2 segundos
    And Marco la casilla Impressive
    And Validar si el elemento SelecImpressive se visualiza
    And Tomar Captura de pantalla: CasillaImpressive

  @WebTables
  Scenario: Web Tables
    And Validar si el elemento WebTables se visualiza
    And Busque el elemento WebTables
    And Hacer Click en El elemento WebTables
    And Busque el elemento Add
    And Hacer Click en El elemento Add
    And lleneme el campo FirstName con el texto Jose
    And lleneme el campo LastName con el texto Bisabuel
    And lleneme el campo EmailRegistration con el texto jose_bisabuel@hotmail.com
    And lleneme el campo Age con el texto 33
    And lleneme el campo Salary con el texto 4480000
    And lleneme el campo Department con el texto Calidad
    And Tomar Captura de pantalla: RegistroLleno
    And Hacer Click en El elemento SubmitRegistration
    And espereme 2 segundos
    And Tomar Captura de pantalla: NuevoRegistro
    And Validar si el elemento FirstNameGuardado contiene el texto Jose
    And Validar si el elemento LastNameGuardado contiene el texto Bisabuel
    And Validar si el elemento AgeGuardado contiene el texto 33
    And Validar si el elemento EmailRegistroGuardado contiene el texto jose_bisabuel@hotmail.com
    And Validar si el elemento SalaryGuardado contiene el texto 4480000
    And Validar si el elemento DepartmenGuardado contiene el texto Calidad

  @WebTablesEdicionBorrado
  Scenario: Web Tables Edicion y Borrado
    And Validar si el elemento WebTables se visualiza
    And Busque el elemento WebTables
    And Hacer Click en El elemento WebTables
    And Busque el elemento Add
    And Hacer Click en El elemento Add
    And lleneme el campo FirstName con el texto Jose
    And lleneme el campo LastName con el texto Bisabuel
    And lleneme el campo EmailRegistration con el texto jose_bisabuel@hotmail.com
    And lleneme el campo Age con el texto 33
    And lleneme el campo Salary con el texto 4480000
    And lleneme el campo Department con el texto Calidad
    And Tomar Captura de pantalla: RegistroLleno
    And Hacer Click en El elemento SubmitRegistration
    And espereme 2 segundos
    And Tomar Captura de pantalla: NuevoRegistro
    And Hacer Click en El elemento EditarRegistro
    And lleneme el campo FirstName con el texto NombreEditado
    And lleneme el campo LastName con el texto ApellidoEditado
    And lleneme el campo EmailRegistration con el texto CorreoEditado@hotmail.com
    And lleneme el campo Age con el texto 999
    And lleneme el campo Salary con el texto 99999
    And lleneme el campo Department con el texto DepartmentEditado
    And Tomar Captura de pantalla: DatosEditados
    And Hacer Click en El elemento SubmitRegistration
    And espereme 2 segundos
    And Tomar Captura de pantalla: EdicionDatos
    And Validar si el elemento FirstNameGuardadoEdit contiene el texto NombreEditado
    And Validar si el elemento LastNameGuardadoEdit contiene el texto ApellidoEditado
    And Validar si el elemento EmailRegistroGuardadoEdit contiene el texto CorreoEditado@hotmail.com
    And Validar si el elemento AgeGuardadoEdit contiene el texto 999
    And Validar si el elemento SalaryGuardadoEdit contiene el texto 99999
    And Validar si el elemento DepartmenGuardadoEdit contiene el texto DepartmentEditado
    And Hacer Click en El elemento EliminarRegistro
    And Tomar Captura de pantalla: RegistroEliminado

  @Buttons
  Scenario: Buttons
    And Validar si el elemento Buttons se visualiza
    And Busque el elemento Buttons
    And Hacer Click en El elemento Buttons
    And Busque el elemento DoubleClickMe
    And Hacer Doble Click en El elemento DoubleClickMe
    And Validar si el elemento DoubleClickMeValid se visualiza
    And Hacer Clic Derecho en El elemento RightClickMe
    And Validar si el elemento RightClickMeValid se visualiza
    And Hacer Click en El elemento ClickMe
    And Validar si el elemento ClickMeValid se visualiza
    And Tomar Captura de pantalla: Validaciones
    And espereme 2 segundos

  @Links
  Scenario: Links
    And Busque el elemento Links
    And Hacer Click en El elemento Links
    And Busque el elemento LinkHome
    And Hacer Click en El elemento LinkHome
    And espereme 1 segundos
    And Tomar Captura de pantalla: LinkHome
    And Validar si el elemento PantallaInicio se visualiza
    And espereme 1 segundos
    And Cerrar la pestaña actual
    #And espereme 2 segundos
    And Hacer Click en El elemento LinkHomeaacsW
    And espereme 1 segundos
    And Tomar Captura de pantalla: LinkHomeaacsW
    And espereme 1 segundos
    And Validar si el elemento PantallaInicio se visualiza
    And Cerrar la pestaña actual
    #And espereme 2 segundos
    #And Busque el elemento Created
    And Hacer Click en El elemento Created
    And Validar si el elemento CreatedValid se visualiza
    And espereme 2 segundos
    And Hacer Click en El elemento NoContent
    And Validar si el elemento NoContentValid se visualiza
    And Tomar Captura de pantalla: NoContent
    And Hacer Click en El elemento Moved
    And Validar si el elemento MovedValid se visualiza
    And Tomar Captura de pantalla: Moved
    And Hacer Click en El elemento BadRequest
    And Validar si el elemento BadRequestValid se visualiza
    And Tomar Captura de pantalla: BadRequest
    And Hacer Click en El elemento Unauthorized
    And Validar si el elemento UnauthorizedValid se visualiza
    And Tomar Captura de pantalla: Unauthorized
    And Hacer Click en El elemento Forbidden
    And Validar si el elemento ForbiddenValid se visualiza
    And Tomar Captura de pantalla: Forbidden
    And Hacer Click en El elemento NotFound
    And Validar si el elemento NotFoundValid se visualiza
    And Tomar Captura de pantalla: NotFound

  @upload/Download
  Scenario: Upload and Download
    And Busque el elemento UploadAndDownload
    And Hacer Click en El elemento UploadAndDownload
    #And Crear un archivo CSV en la ruta C:\Users\Public\AutomatizacionJuJu\src\test\resources\Documento
    And Busque el elemento CargarDoc
    And Subir Archivo CargarDoc
    And Validar si el elemento DocumentoCargado se visualiza
    And espereme 2 segundos
    And Hacer Click en El elemento Download
    And espereme 2 segundos
    And Validar que el archivo se haya descargado correctamente
    And espereme 2 segundos
