Feature: Distance
  As a user
  I want to test distance site functionality
  So that I can be sure that the site calculates the distance correctly

  #The test will not pass, according to the specifications, the distance is 2425 km, but the site gives a value of 2423
  Scenario Outline: Check the distance between two cities
    Given User opens '<mainPage>' page
    And User opens Distance tab
    When User types '<routeFrom>' route from location
    And User types '<routeTo>' route to location
    And User select '<transportType>' transport type
    And User click on the Go button
    Then User check '<distance>' distance between cities
    Examples:
      | mainPage                       | routeFrom      | routeTo  | transportType  | distance         |
      | https://www.openstreetmap.org/ | Радищева, Київ | Кембридж | Bicycle (OSRM) | Distance: 2425km |
