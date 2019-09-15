#Author: your.email@your.domain.com

@testrows
Feature: Check rows in the two tables are same

  @test1
  Scenario: Row counts in two tables from different schema are same
    Given I am connected to Sakila database
    And The tables film_category and film_cate in sakila are there 
    When I call no_of_films_cat procedure for table film_category
    Then the count of rows is equal to table film_cate rows
    And the resources are closed
    

  
