Feature: Modulo Forms

  Background:
    Given Cargar Pagina Web DemoQa
    Then Cargar la informacion del DOM ModuloForms.json
    And Validar si el elemento PantallaInicio se visualiza
    And Tomar Captura de pantalla: PaginaInicio
    And Adjunto una Captura de pantalla al informe PaginaInicio
    And espereme 2 segundos
    And Busque el elemento ModuloForms
    And Hacer Click en El elemento ModuloForms
    And espereme 2 segundos

  @PracticeForm
  Scenario: Practice Form
    And Busque el elemento PracticeForm
    And Hacer Click en El elemento PracticeForm
    And espereme 2 segundos
    And Busque el elemento FirstName
    And lleneme el campo FirstName con el texto Jose
    And lleneme el campo LastName con el texto Bisabuel
    And lleneme el campo Email con el texto jose_bisabuel@hotmail.com
    And Marco la casilla Male
    And lleneme el campo MobileNumber con el texto 3193034610
    And Hacer Click en El elemento DateOfBirth
    And espereme 2 segundos
    And Hacer Click en El elemento Select01/10/2024
    And espereme 2 segundos
    #And Hacer Click en El elemento Subjects
    #And Escribir en la casilla Subjets la letra M y seleccionar la opción Maths
    And Marco la casilla Hobbies(Sport)
    And Marco la casilla Hobbies(Reading)
    And Marco la casilla Hobbies(Music)
    And Subir la foto Pictures
    And espereme 2 segundos
    And Tomar Captura de pantalla: FotoCargada
    And espereme 2 segundos
    And lleneme el campo CurrentAddress con el texto Neiva, Huila
    And Busque el elemento State
    And Hacer Click en El elemento State
    And Hacer Click en El elemento Haryana
    And espereme 2 segundos
    And Hacer Click en El elemento City
    And Hacer Click en El elemento Karnal
    And espereme 2 segundos
    And Hacer Click en El elemento Submit
    And espereme 1 segundos
    And Tomar Captura de pantalla: FormPractice
    And Validar si el elemento StudentName contiene el texto Jose Bisabuel
    And Validar si el elemento SudentEmail contiene el texto jose_bisabuel@hotmail.com
    And Validar si el elemento Gender contiene el texto Male
    And Validar si el elemento Mobile contiene el texto 3193034610
    And Validar si el elemento DateBirth contiene el texto 01 October,2024
    #And Validar si el elemento SubjetsValid contiene el texto Arts
    And Validar si el elemento HobbiesValid contiene el texto Sports, Reading, Music
    And espereme 1 segundos
    And Busque el elemento AddressValid
    And Validar si el elemento PictureValid contiene el texto Foto
    And Validar si el elemento AddressValid contiene el texto Neiva, Huila
    And Validar si el elemento StateAndCity contiene el texto Haryana Karnal
    And espereme 2 segundos

  Scenario Outline: Practice Form More
    And Busque el elemento PracticeForm
    And Hacer Click en El elemento PracticeForm
    And espereme 2 segundos
    And Busque el elemento FirstName
    And lleneme el campo FirstName con el texto Jose
    And lleneme el campo LastName con el texto Bisabuel
    And lleneme el campo Email con el texto jose_bisabuel@hotmail.com
    #Gender
    And Marco la casilla <Campo1>
    And lleneme el campo MobileNumber con el texto 3193034610
    And Hacer Click en El elemento DateOfBirth
    #SeleccionarFecha
    And Hacer Click en El elemento <Campo2>
    #Hobbies
    And Marco la casilla <Campo3>
    And Subir la foto Pictures
    And espereme 2 segundos
    And Tomar Captura de pantalla: FotoCargada
    And espereme 2 segundos
    And lleneme el campo CurrentAddress con el texto Neiva, Huila
    And Busque el elemento State
    And Hacer Click en El elemento State
    #SelectEstate
    And Hacer Click en El elemento <Campo4>
    And espereme 2 segundos
    And Hacer Click en El elemento City
    And Hacer Click en El elemento <Campo5>
    And espereme 2 segundos
    And Hacer Click en El elemento Submit
    And Tomar Captura de pantalla: FormPractice
    And espereme 1 segundos


    Examples:
      | Campo1 | Campo2           | Campo3           |  Campo4    | Campo5   |
      | Male   | Select01/10/2024 | Hobbies(Sport)   |  NRC       |  Delhi   |
      | Male   | Select02/10/2024 | Hobbies(Reading) |  NRC       |  Gurgaon |
      | Male   | Select01/10/2024 | Hobbies(Music)   |  NRC       |  Noida   |
      | Female | Select05/10/2024 | Hobbies(Sport)   |UltraPradesh|  Agra    |
      | Female | Select05/10/2024 | Hobbies(Reading) |UltraPradesh|  Lucknow |
      | Female | Select05/10/2024 | Hobbies(Music)   |UltraPradesh|  Merrut  |
      | Other  | Select30/09/2024 | Hobbies(Sport)   |  Haryana   |  Karnal  |
      | Other  | Select30/09/2024 | Hobbies(Reading) |  Haryana   |  Panipat |
      | Other  | Select30/09/2024 | Hobbies(Music)   |  Rajasthan |  Jaipur  |
