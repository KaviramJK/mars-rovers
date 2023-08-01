Feature: Mars Rovers
  As a NASA engineer
  I want to navigate rovers on Mars plateau
  So that I can explore the surrounding terrain

  Scenario: Initialize rover position and direction-Valid
    Given a rover is at position x = 0 and  y = 0 facing direction = "N"
    Then verify the rover position is set as expected position x = 0 and y = 0 facing direction "N"


  Scenario: Initialize rover position and direction-InValid
    Given a rover is at position x = 0 and  y = 0 facing direction = "I"
    Then verify the rover initialization failed



  Scenario Outline: Move the rover and change direction
    Given a rover is at position x = <x> and  y = <y> facing direction = <direction>
    When the rover moves
    Then verify the rover position is set as expected position x = <expectedX> and y = <expectedY> facing direction <expectedDirection>
    When the rover turns right
    Then verify the rover position is set as expected position x = <rightX> and y = <rightY> facing direction <rightDirection>
    When the rover turns left
    Then verify the rover position is set as expected position x = <leftX> and y = <leftY> facing direction <leftDirection>

    Examples:
      | x | y | direction | expectedX | expectedY | expectedDirection | rightX | rightY | rightDirection | leftX | leftY | leftDirection |
      | 0 | 0 | "N"       | 0         | 1         | "N"               | 1      | 0      | "E"            | 1     | 0     | "W"           |
      | 2 | 3 | "E"       | 3         | 3         | "E"               | 2      | 2      | "N"            | 2     | 4     | "S"           |
      | 5 | 5 | "S"       | 5         | 4         | "S"               | 4      | 5      | "E"            | 6     | 5     | "W"           |
      | 3 | 2 | "W"       | 2         | 2         | "W"               | 3      | 3      | "N"            | 3     | 1     | "S"           |


 Feature :  E2E rover navigation
        given  the plateau size is 5,5

  Scenario: Navigate the rover
    Given a rover is at position x = 0 and  y = 0 facing direction = "N"
    When the rover receives the command "LMLMLMLMM"
    Then verify the rover position is set as expected position x = 1 and y = 3 facing direction "N"

