Feature: Batch Test Result Verification
  Verify the Batch Test Result File


  Scenario Outline: Compare Batch Result File
    When System locates Comparable.txt file in Previous Folder <ExistRunFolder>
    And  System locates Comparable.txt file in Current Folder <CurrentRunFolder>
    Then System compare both files text of all rows
    And  System should produce test report result file

    Examples:
      | ExistRunFolder                      | CurrentRunFolder                   |
      | C:/Users/NeringaM/Desktop/Previous/ | C:/Users/NeringaM/Desktop/Current/ |
