Feature: Evalart Main Page

  As a Evalart user
  I want to complete the different questions
  to complete the flow and retrieve the hashcode

  Scenario Outline: Login into Evalart and complete the math operations form
    Given that an user is on Evalart Home Page
    When he logs with correct credentials
      | username   | password   |
      | <username> | <password> |
    And he completes the math operations form
    Then he retrieves the hashcode

    Examples:
      | username | password                                         |
      ##@externaldata@src/test/resources/datadriven/evalart.xlsx@usuario
      | 786479   | 10df2f32286b7120MS00LTk3NDY4Nw==30e0c83e6c29f1c3 |
